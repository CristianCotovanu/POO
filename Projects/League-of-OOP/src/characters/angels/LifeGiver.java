package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import grandmagician.NotificationType;
import grandmagician.ObserverInformation;

public final class LifeGiver extends Angel {
    public LifeGiver(final int posX, final int posY) {
        super(posX, posY);
        type = AngelType.LifeGiver;
    }

    @Override
    public void visitHero(final Pyromancer pyromancer) {
        setHpWithMaxLimit(pyromancer, AngelConstants.LIFEGIVER_HP_TO_PYRO);
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, pyromancer, null));
    }

    @Override
    public void visitHero(final Knight knight) {
        setHpWithMaxLimit(knight, AngelConstants.LIFEGIVER_HP_TO_KNIGHT);
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, knight, null));
    }

    @Override
    public void visitHero(final Rogue rogue) {
        setHpWithMaxLimit(rogue, AngelConstants.LIFEGIVER_HP_TO_ROGUE);
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, rogue, null));
    }

    @Override
    public void visitHero(final Wizard wizard) {
        setHpWithMaxLimit(wizard, AngelConstants.LIFEGIVER_HP_TO_WIZARD);
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, wizard, null));
    }
}
