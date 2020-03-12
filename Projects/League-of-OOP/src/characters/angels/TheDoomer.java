package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import grandmagician.NotificationType;
import grandmagician.ObserverInformation;

public final class TheDoomer extends Angel {
    public TheDoomer(final int posX, final int posY) {
        super(posX, posY);
        type = AngelType.TheDoomer;
    }

    @Override
    public void visitHero(final Pyromancer pyromancer) {
        pyromancer.setCurrentHp(0);
        notifyObserver(new ObserverInformation(NotificationType.AngelHit, this, pyromancer, null));
        notifyObserver(new ObserverInformation(NotificationType.AngelKill, this, pyromancer, null));
    }

    @Override
    public void visitHero(final Knight knight) {
        knight.setCurrentHp(0);
        notifyObserver(new ObserverInformation(NotificationType.AngelHit, this, knight, null));
        notifyObserver(new ObserverInformation(NotificationType.AngelKill, this, knight, null));
    }

    @Override
    public void visitHero(final Rogue rogue) {
        rogue.setCurrentHp(0);
        notifyObserver(new ObserverInformation(NotificationType.AngelHit, this, rogue, null));
        notifyObserver(new ObserverInformation(NotificationType.AngelKill, this, rogue, null));
    }

    @Override
    public void visitHero(final Wizard wizard) {
        wizard.setCurrentHp(0);
        notifyObserver(new ObserverInformation(NotificationType.AngelHit, this, wizard, null));
        notifyObserver(new ObserverInformation(NotificationType.AngelKill, this, wizard, null));
    }
}
