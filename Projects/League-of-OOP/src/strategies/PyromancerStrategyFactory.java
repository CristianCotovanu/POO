package strategies;

import characters.heroes.Hero;

public final class PyromancerStrategyFactory implements StrategyFactory {
    private static PyromancerStrategyFactory instance = null;

    private PyromancerStrategyFactory() { }

    @Override
    public OffensiveStrategy createOffensiveStrategy(final Hero strategyUser) {
        return new OffensiveStrategy(strategyUser, StrategiesConstants.PYRO_OFFENSIVE_DMG_BUFF,
                StrategiesConstants.PYRO_OFFENSIVE_HP_DEBUFF);
    }

    @Override
    public DefensiveStrategy createDefensiveStrategy(final Hero strategyUser) {
        return new DefensiveStrategy(strategyUser, StrategiesConstants.PYRO_DEFENSIVE_DMG_DEBUFF,
                StrategiesConstants.PYRO_DEFENSIVE_HP_BUFF);
    }

    public static PyromancerStrategyFactory getInstance() {
        if (instance == null) {
            instance = new PyromancerStrategyFactory();
        }
        return instance;
    }
}
