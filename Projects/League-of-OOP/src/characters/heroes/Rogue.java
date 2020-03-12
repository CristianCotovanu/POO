package characters.heroes;

import characters.angels.IAngelVisitorToHero;
import skills.IHeroVisitor;
import strategies.RogueStrategyFactory;
import strategies.StrategiesConstants;

import static characters.heroes.HeroConstants.ROGUE_HP_LVL_UP;
import static characters.heroes.HeroConstants.ROGUE_INITIAL_HP;
import static characters.heroes.HeroConstants.ROGUE_RACE;

public final class Rogue extends Hero {
    Rogue() {
        super();
        this.race = ROGUE_RACE;
        this.currentHp = ROGUE_INITIAL_HP;
        this.maxHp = ROGUE_INITIAL_HP;
    }

    @Override
    public void acceptSkill(final IHeroVisitor skill) {
        skill.applyEffect(this);
    }

    @Override
    public void acceptAngel(final IAngelVisitorToHero angel) {
        angel.visitHero(this);
    }

    protected void healUp(final int currentLevel) {
        currentHp = ROGUE_INITIAL_HP + currentLevel * ROGUE_HP_LVL_UP;
        maxHp = currentHp;
    }

    @Override
    public void applyProperStrategy() {
        RogueStrategyFactory rogueStrategyFactory = RogueStrategyFactory.getInstance();

        int lowerBoundHp = (int) (maxHp * StrategiesConstants.ROGUE_LOWER_BOUND);
        int upperBoundHp = (int) (maxHp * StrategiesConstants.ROGUE_UPPER_BOUND);

        if (upperBoundHp > currentHp && currentHp > lowerBoundHp) {
            strategy = rogueStrategyFactory.createOffensiveStrategy(this);
        } else if (currentHp < lowerBoundHp) {
            strategy = rogueStrategyFactory.createDefensiveStrategy(this);
        } else {
            return;
        }
        strategy.applyStrategy();
    }
}
