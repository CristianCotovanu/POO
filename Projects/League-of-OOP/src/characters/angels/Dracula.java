package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import grandmagician.NotificationType;
import grandmagician.ObserverInformation;

public final class Dracula extends Angel {
    public Dracula(final int posX, final int posY) {
        super(posX, posY);
        type = AngelType.Dracula;
    }

    @Override
    public void visitHero(final Pyromancer pyromancer) {
        pyromancer.setCurrentHp(pyromancer.getCurrentHp() - AngelConstants.DRACULA_DMG_TO_PYRO);
        pyromancer.addDamageModifier(-AngelConstants.DRACULA_DEBUFF_TO_PYRO);
        notifyObserver(new ObserverInformation(NotificationType.AngelHit, this, pyromancer, null));
        notifyMagicianIfTargetIsDead(pyromancer);
    }

    @Override
    public void visitHero(final Knight knight) {
        knight.setCurrentHp(knight.getCurrentHp() - AngelConstants.DRACULA_DMG_TO_KNIGHT);
        knight.addDamageModifier(-AngelConstants.DRACULA_DEBUFF_TO_KNIGHT);
        notifyObserver(new ObserverInformation(NotificationType.AngelHit, this, knight, null));
        notifyMagicianIfTargetIsDead(knight);

    }

    @Override
    public void visitHero(final Rogue rogue) {
        rogue.setCurrentHp(rogue.getCurrentHp() - AngelConstants.DRACULA_DMG_TO_ROGUE);
        rogue.addDamageModifier(-AngelConstants.DRACULA_DEBUFF_TO_ROGUE);
        notifyObserver(new ObserverInformation(NotificationType.AngelHit, this, rogue, null));
        notifyMagicianIfTargetIsDead(rogue);

    }

    @Override
    public void visitHero(final Wizard wizard) {
        wizard.setCurrentHp(wizard.getCurrentHp() - AngelConstants.DRACULA_DMG_TO_WIZARD);
        wizard.addDamageModifier(-AngelConstants.DRACULA_DEBUFF_TO_WIZARD);
        notifyObserver(new ObserverInformation(NotificationType.AngelHit, this, wizard, null));
        notifyMagicianIfTargetIsDead(wizard);
    }
}
