package game;

import characters.heroes.Hero;
import grandmagician.GrandMagician;
import grandmagician.NotificationType;
import grandmagician.Observable;
import grandmagician.ObserverInformation;
import map.Terrain;
import skills.Skill;
import skills.SkillFactory;

import java.util.List;

import static characters.heroes.HeroConstants.OPERAND1_EXP_FORMULA;
import static characters.heroes.HeroConstants.OPERAND2_EXP_FORMULA;

public final class Fight extends Observable {
    private Hero caster;
    private Hero victim;

    public Fight(final Hero caster, final Hero victim) {
        super(GrandMagician.getInstance());
        this.caster = caster;
        this.victim = victim;
    }

    void startFight(final Terrain terrain) {
        SkillFactory skillFactory = SkillFactory.getInstance();
        List<Skill> skills = skillFactory.createSkill(caster, terrain);

        int victimHpBeforeFight = victim.getCurrentHp();
        for (Skill skill : skills) {
            victim.acceptSkill(skill);
        }
        int victimHpAfterFight = victim.getCurrentHp();

        skills = skillFactory.createSkill(victim, terrain);
        victim.setCurrentHp(victimHpBeforeFight);
        for (Skill skill : skills) {
            caster.acceptSkill(skill);
        }
        victim.setCurrentHp(victimHpAfterFight + (victim.getCurrentHp() - victimHpBeforeFight));

        if (victim.isDead() && caster.isDead()) {
            notifyObserver(new ObserverInformation(NotificationType.PlayerKill, null,
                    caster, victim));
            notifyObserver(new ObserverInformation(NotificationType.PlayerKill, null,
                    victim, caster));

            int casterLevelBeforeFight = caster.getLevel();
            int casterHpBeforeFight = caster.getCurrentHp();
            computeXpAfterFight(caster, victim);

            int casterLevelAfterFight = caster.getLevel();
            caster.setLevel(casterLevelBeforeFight);
            caster.setCurrentHp(casterHpBeforeFight);

            computeXpAfterFight(victim, caster);

            caster.setLevel(casterLevelAfterFight);
            victim.setCurrentHp(0);
            caster.setCurrentHp(0);
            return;
        }

        if (caster.isDead()) {
            notifyObserver(new ObserverInformation(NotificationType.PlayerKill, null,
                    victim, caster));
            computeXpAfterFight(victim, caster);
        }
        if (victim.isDead()) {
            notifyObserver(new ObserverInformation(NotificationType.PlayerKill, null,
                    caster, victim));
            computeXpAfterFight(caster, victim);
        }
    }

    private void computeXpAfterFight(final Hero attacker, final Hero target) {
        if (target.isDead()) {
            attacker.addExperiencePoints(Integer.max(0, OPERAND1_EXP_FORMULA
                            - (attacker.getLevel() - target.getLevel()) * OPERAND2_EXP_FORMULA));
        }
    }
}
