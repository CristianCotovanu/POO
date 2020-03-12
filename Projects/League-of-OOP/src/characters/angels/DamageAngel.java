package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import grandmagician.NotificationType;
import grandmagician.ObserverInformation;

public final class DamageAngel extends Angel {
    public DamageAngel(final int posX, final int posY) {
        super(posX, posY);
        type = AngelType.DamageAngel;
    }

    @Override
    public void visitHero(final Pyromancer pyromancer) {
        pyromancer.addDamageModifier(AngelConstants.DAMAGEANGEL_BUFF_TO_PYRO);
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, pyromancer, null));
    }

    @Override
    public void visitHero(final Knight knight) {
        knight.addDamageModifier(AngelConstants.DAMAGEANGEL_BUFF_TO_KNIGHT);
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, knight, null));

    }

    @Override
    public void visitHero(final Rogue rogue) {
        rogue.addDamageModifier(AngelConstants.DAMAGEANGEL_BUFF_TO_ROGUE);
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, rogue, null));
    }

    @Override
    public void visitHero(final Wizard wizard) {
        wizard.addDamageModifier(AngelConstants.DAMAGEANGEL_BUFF_TO_WIZARD);
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, wizard, null));
    }
}
