package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import grandmagician.NotificationType;
import grandmagician.ObserverInformation;

public final class XPAngel extends Angel {
    public XPAngel(final int posX, final int posY) {
        super(posX, posY);
        type = AngelType.XPAngel;
    }

    @Override
    public void visitHero(final Pyromancer pyromancer) {
        if (pyromancer.isDead()) {
            return;
        }
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, pyromancer, null));
        pyromancer.addExperiencePoints(AngelConstants.XPANGEL_TO_PYRO);
    }

    @Override
    public void visitHero(final Knight knight) {
        if (knight.isDead()) {
            return;
        }
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, knight, null));
        knight.addExperiencePoints(AngelConstants.XPANGEL_TO_KNIGHT);
    }


    @Override
    public void visitHero(final Rogue rogue) {
        if (rogue.isDead()) {
            return;
        }
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, rogue, null));
        rogue.addExperiencePoints(AngelConstants.XPANGEL_TO_ROGUE);
    }

    @Override
    public void visitHero(final Wizard wizard) {
        if (wizard.isDead()) {
            return;
        }
        notifyObserver(new ObserverInformation(NotificationType.AngelHelp, this, wizard, null));
        wizard.addExperiencePoints(AngelConstants.XPANGEL_TO_WIZARD);
    }
}
