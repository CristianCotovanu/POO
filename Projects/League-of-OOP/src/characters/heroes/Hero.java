package characters.heroes;

import characters.angels.IAngelVisitorToHero;
import grandmagician.GrandMagician;
import grandmagician.NotificationType;
import grandmagician.Observable;
import grandmagician.ObserverInformation;
import skills.effects.DamageOverTime;
import skills.effects.Stun;
import strategies.Strategy;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero extends Observable implements ISkillVisitable, IAngelVisitable {
    protected String race;
    protected int maxHp;
    protected int currentHp;
    private int initialPosition;
    private int currentXp;
    protected int level;
    private int posX;
    private int posY;
    private DamageOverTime damageOverTime;
    private Stun stun;
    private List<Float> damageModifiers;
    protected Strategy strategy;

    public Hero() {
        super(GrandMagician.getInstance());
        level = HeroConstants.INITIAL_LVL;
        currentXp = HeroConstants.INITIAL_XP;
        stun = new Stun();
        damageOverTime = new DamageOverTime();
        damageModifiers = new ArrayList<>();
    }

    public abstract void acceptAngel(IAngelVisitorToHero angel);

    public abstract void applyProperStrategy();

    protected abstract void healUp(int currentLevel);

    public final boolean isDead() {
        return currentHp <= 0;
    }

    public final boolean isStunned() {
        return stun.getRounds() > 0;
    }

    public final void useStrategy() {
        if (!isStunned()) {
            applyProperStrategy();
        }
    }

    public final float computeDamageModifier(final float raceModifier) {
        float totalDamageModifier = raceModifier;
        for (Float damageModifier : damageModifiers) {
            totalDamageModifier += damageModifier;
        }
        return totalDamageModifier;
    }

    public final void addExperiencePoints(final int expPoints) {
        if (level >= 1 && expPoints >= HeroConstants.XP_NEEDED_FOR_LVLUP - (getCurrentXp()
                - HeroConstants.XP_NEEDED_FIRST_TRANSITION) % HeroConstants.XP_NEEDED_FOR_LVLUP) {
            int remainingExp = expPoints - (HeroConstants.XP_NEEDED_FOR_LVLUP - ((getCurrentXp()
                    - HeroConstants.XP_NEEDED_FIRST_TRANSITION)
                    % HeroConstants.XP_NEEDED_FOR_LVLUP));

            currentXp += HeroConstants.XP_NEEDED_FOR_LVLUP - ((getCurrentXp()
                    - HeroConstants.XP_NEEDED_FIRST_TRANSITION)
                    % HeroConstants.XP_NEEDED_FOR_LVLUP);
            level++;
            healUp(level);
            notifyObserver(new ObserverInformation(NotificationType.LevelUp, null, this, null));
            addExperiencePoints(remainingExp);
        } else if (level == 0
                && expPoints >= HeroConstants.XP_NEEDED_FIRST_TRANSITION - getCurrentXp()) {
            int remainingExp = expPoints
                    - (HeroConstants.XP_NEEDED_FIRST_TRANSITION - getCurrentXp());
            currentXp += HeroConstants.XP_NEEDED_FIRST_TRANSITION - getCurrentXp();
            level++;
            healUp(level);
            notifyObserver(new ObserverInformation(NotificationType.LevelUp, null, this, null));
            addExperiencePoints(remainingExp);
        } else {
            if (expPoints <= 0) {
                return;
            }
            currentXp += expPoints;
        }
    }

    public final void addDamageModifier(final float damageBuff) {
        damageModifiers.add(damageBuff);
    }

    public final String getRace() {
        return race;
    }

    public final int getMaxHp() {
        return maxHp;
    }

    public final int getCurrentHp() {
        return currentHp;
    }

    public final void setCurrentHp(final int currentHp) {
        this.currentHp = currentHp;
    }

    public final int getCurrentXp() {
        return currentXp;
    }

    public final int getLevel() {
        return level;
    }

    public final DamageOverTime getDamageOverTime() {
        return damageOverTime;
    }

    public final void setDamageOverTime(final DamageOverTime damageOverTime) {
        this.damageOverTime = damageOverTime;
    }

    public final Stun getStun() {
        return stun;
    }

    public final void setStun(final Stun stun) {
        this.stun = stun;
    }

    public final int getPosX() {
        return posX;
    }

    public final void setPosX(final int posX) {
        this.posX = posX;
    }

    public final int getPosY() {
        return posY;
    }

    public final void setPosY(final int posY) {
        this.posY = posY;
    }

    public final void setInitialPosition(final int initialPosition) {
        this.initialPosition = initialPosition;
    }

    public final void setLevel(final int level) {
        this.level = level;
    }

    public final int getInitialPosition() {
        return initialPosition;
    }
}
