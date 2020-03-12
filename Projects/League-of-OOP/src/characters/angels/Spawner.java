package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import grandmagician.NotificationType;
import grandmagician.ObserverInformation;

public final class Spawner extends Angel {
    public Spawner(final int posX, final int posY) {
        super(posX, posY);
        type = AngelType.Spawner;
    }

    @Override
    public void visitHero(final Pyromancer pyromancer) {
        pyromancer.setCurrentHp(AngelConstants.SPAWNER_HP_TO_PYRO);
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this,
                pyromancer, null));
        notifyObserver(new ObserverInformation(NotificationType.AngelRevive, this,
                pyromancer, null));
    }

    @Override
    public void visitHero(final Knight knight) {
        knight.setCurrentHp(AngelConstants.SPAWNER_HP_TO_KNIGHT);
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, knight, null));
        notifyObserver(new ObserverInformation(NotificationType.AngelRevive, this, knight, null));
    }

    @Override
    public void visitHero(final Rogue rogue) {
        rogue.setCurrentHp(AngelConstants.SPAWNER_HP_TO_ROGUE);
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, rogue, null));
        notifyObserver(new ObserverInformation(NotificationType.AngelRevive, this, rogue, null));
    }

    @Override
    public void visitHero(final Wizard wizard) {
        wizard.setCurrentHp(AngelConstants.SPAWNER_HP_TO_WIZARD);
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, wizard, null));
        notifyObserver(new ObserverInformation(NotificationType.AngelRevive, this, wizard, null));
    }
}
