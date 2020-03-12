package characters.angels;

import characters.heroes.Hero;
import characters.heroes.HeroConstants;
import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import grandmagician.NotificationType;
import grandmagician.ObserverInformation;

public final class LevelUpAngel extends Angel {
    public LevelUpAngel(final int posX, final int posY) {
        super(posX, posY);
        type = AngelType.LevelUpAngel;
    }

    private void computeAndSetExperienceNeeded(final Hero hero) {
        if (hero.getCurrentXp() < HeroConstants.XP_NEEDED_FIRST_TRANSITION) {
            hero.addExperiencePoints(HeroConstants.XP_NEEDED_FIRST_TRANSITION
                    - hero.getCurrentXp());
        } else {
            int xpNeeded = HeroConstants.XP_NEEDED_FOR_LVLUP - ((hero.getCurrentXp()
                    - HeroConstants.XP_NEEDED_FIRST_TRANSITION)
                    % HeroConstants.XP_NEEDED_FOR_LVLUP);
            hero.addExperiencePoints(xpNeeded);
        }
    }

    @Override
    public void visitHero(final Pyromancer pyromancer) {
        if (pyromancer.isDead()) {
            return;
        }
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this,
                pyromancer, null));
        computeAndSetExperienceNeeded(pyromancer);
        pyromancer.addDamageModifier(AngelConstants.LEVELUPANGEL_BUFF_TO_PYRO);
    }

    @Override
    public void visitHero(final Knight knight) {
        if (knight.isDead()) {
            return;
        }
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, knight, null));
        computeAndSetExperienceNeeded(knight);
        knight.addDamageModifier(AngelConstants.LEVELUPANGEL_BUFF_TO_KNIGHT);
    }

    @Override
    public void visitHero(final Rogue rogue) {
        if (rogue.isDead()) {
            return;
        }
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, rogue, null));
        computeAndSetExperienceNeeded(rogue);
        rogue.addDamageModifier(AngelConstants.LEVELUPANGEL_BUFF_TO_ROGUE);
    }

    @Override
    public void visitHero(final Wizard wizard) {
        if (wizard.isDead()) {
            return;
        }
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, wizard, null));
        computeAndSetExperienceNeeded(wizard);
        wizard.addDamageModifier(AngelConstants.LEVELUPANGEL_BUFF_TO_WIZARD);
    }
}
