package strategies;

import characters.heroes.Hero;



public final class RogueStrategyFactory implements StrategyFactory {
    private static RogueStrategyFactory instance = null;

    private RogueStrategyFactory() { }

    @Override
    public OffensiveStrategy createOffensiveStrategy(final Hero strategyUser) {
        return new OffensiveStrategy(strategyUser, StrategiesConstants.ROGUE_OFFENSIVE_DMG_BUFF,
                StrategiesConstants.ROGUE_OFFENSIVE_HP_DEBUFF);
    }

    @Override
    public DefensiveStrategy createDefensiveStrategy(final Hero strategyUser) {
        return new DefensiveStrategy(strategyUser, StrategiesConstants.ROGUE_DEFENSIVE_DMG_DEBUFF,
                StrategiesConstants.ROGUE_DEFENSIVE_HP_BUFF);
    }

    public static RogueStrategyFactory getInstance() {
        if (instance == null) {
            instance = new RogueStrategyFactory();
        }
        return instance;
    }
}
