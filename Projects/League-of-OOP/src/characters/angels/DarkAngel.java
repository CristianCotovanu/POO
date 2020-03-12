package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import grandmagician.NotificationType;
import grandmagician.ObserverInformation;

public final class DarkAngel extends Angel {
    public DarkAngel(final int posX, final int posY) {
        super(posX, posY);
        type = AngelType.DarkAngel;
    }

    @Override
    public void visitHero(final Pyromancer pyromancer) {
        pyromancer.setCurrentHp(pyromancer.getCurrentHp() - AngelConstants.DARKANGEL_TO_PYRO);
        notifyObserver(new ObserverInformation(NotificationType.AngelHit, this, pyromancer, null));
        notifyMagicianIfTargetIsDead(pyromancer);
    }

    @Override
    public void visitHero(final Knight knight) {
        knight.setCurrentHp(knight.getCurrentHp() - AngelConstants.DARKANGEL_TO_KNIGHT);
        notifyObserver(new ObserverInformation(NotificationType.AngelHit, this, knight, null));
        notifyMagicianIfTargetIsDead(knight);
    }

    @Override
    public void visitHero(final Rogue rogue) {
        rogue.setCurrentHp(rogue.getCurrentHp() - AngelConstants.DARKANGEL_TO_ROGUE);
        notifyObserver(new ObserverInformation(NotificationType.AngelHit, this, rogue, null));
        notifyMagicianIfTargetIsDead(rogue);
    }

    @Override
    public void visitHero(final Wizard wizard) {
        wizard.setCurrentHp(wizard.getCurrentHp() - AngelConstants.DARKANGEL_TO_WIZARD);
        notifyObserver(new ObserverInformation(NotificationType.AngelHit, this, wizard, null));
        notifyMagicianIfTargetIsDead(wizard);
    }
}
