package strategies;

import characters.heroes.Hero;

public final class KnightStrategyFactory implements StrategyFactory {
    private static KnightStrategyFactory instance = null;

    private KnightStrategyFactory() { }

    @Override
    public OffensiveStrategy createOffensiveStrategy(final Hero strategyUser) {
        return new OffensiveStrategy(strategyUser, StrategiesConstants.KNIGHT_OFFENSIVE_DMG_BUFF,
                StrategiesConstants.KNIGHT_OFFENSIVE_HP_DEBUFF);
    }

    @Override
    public DefensiveStrategy createDefensiveStrategy(final Hero strategyUser) {
        return new DefensiveStrategy(strategyUser, StrategiesConstants.KNIGHT_DEFENSIVE_DMG_DEBUFF,
                StrategiesConstants.KNIGHT_DEFENSIVE_HP_BUFF);
    }

    public static KnightStrategyFactory getInstance() {
        if (instance == null) {
            instance = new KnightStrategyFactory();
        }
        return instance;
    }
}
