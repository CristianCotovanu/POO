package strategies;

import characters.heroes.Hero;

public final class WizardStrategyFactory implements StrategyFactory {
    private static WizardStrategyFactory instance = null;

    private WizardStrategyFactory() { }

    @Override
    public OffensiveStrategy createOffensiveStrategy(final Hero strategyUser) {
        return new OffensiveStrategy(strategyUser, StrategiesConstants.WIZARD_OFFENSIVE_DMG_BUFF,
                StrategiesConstants.WIZARD_OFFENSIVE_HP_DEBUFF);
    }

    @Override
    public DefensiveStrategy createDefensiveStrategy(final Hero strategyUser) {
        return new DefensiveStrategy(strategyUser, StrategiesConstants.WIZARD_DEFENSIVE_DMG_DEBUFF,
                StrategiesConstants.WIZARD_DEFENSIVE_HP_BUFF);
    }

    public static WizardStrategyFactory getInstance() {
        if (instance == null) {
            instance = new WizardStrategyFactory();
        }
        return instance;
    }
}
