package strategies;

import characters.heroes.Hero;

public interface StrategyFactory {
    OffensiveStrategy createOffensiveStrategy(Hero strategyUser);
    DefensiveStrategy createDefensiveStrategy(Hero strategyUser);
}
