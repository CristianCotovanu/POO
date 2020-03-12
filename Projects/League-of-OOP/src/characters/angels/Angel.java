package characters.angels;

import characters.heroes.Hero;
import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import grandmagician.GrandMagician;
import grandmagician.NotificationType;
import grandmagician.Observable;
import grandmagician.ObserverInformation;

public abstract class Angel extends Observable implements IAngelVisitorToHero {
    protected AngelType type;
    private int posX;
    private int posY;

    public Angel(final int posX, final int posY) {
        super(GrandMagician.getInstance());
        this.posX = posX;
        this.posY = posY;

        ObserverInformation observerInformation
                = new ObserverInformation(NotificationType.AngelSpawn, this, null, null);
        notifyObserver(observerInformation);
    }

    final void setHpWithMaxLimit(final Hero hero, final int hpAdded) {
        hero.setCurrentHp(Math.min(hero.getCurrentHp() + hpAdded, hero.getMaxHp()));
    }

    final void notifyMagicianIfTargetIsDead(final Hero target) {
        if (target.isDead()) {
            notifyObserver(new ObserverInformation(NotificationType.AngelKill, this, target, null));
        }
    }

    /**
     *  @param pyromancer type of hero visited
     */
    @Override
    public abstract void visitHero(Pyromancer pyromancer);

    /**
     *  @param knight type of hero visited
     */
    @Override
    public abstract void visitHero(Knight knight);

    /**
     *  @param rogue type of hero visited
     */
    @Override
    public abstract void visitHero(Rogue rogue);

    /**
     *  @param wizard type of hero visited
     */
    @Override
    public abstract void visitHero(Wizard wizard);

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
}
