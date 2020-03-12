package strategies;

import characters.heroes.Hero;

public final class DefensiveStrategy extends Strategy {
    DefensiveStrategy(final Hero strategyUser, final float damageModifier,
                      final float hpModifier) {
        super(strategyUser, damageModifier, hpModifier);
    }

    @Override
    public void applyStrategy() {
        strategyUser.setCurrentHp(strategyUser.getCurrentHp()
                + Math.round(strategyUser.getCurrentHp() * hpModifier));
        strategyUser.addDamageModifier(-damageModifier);
    }
}
