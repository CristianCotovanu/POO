package strategies;

import characters.heroes.Hero;

public abstract class Strategy {
    protected Hero strategyUser;
    protected float damageModifier;
    protected float hpModifier;

    Strategy(final Hero strategyUser, final float damageModifier, final float hpModifier) {
        this.strategyUser = strategyUser;
        this.damageModifier = damageModifier;
        this.hpModifier = hpModifier;
    }

    public abstract void applyStrategy();
}
