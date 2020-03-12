package characters.heroes;

import characters.angels.IAngelVisitorToHero;
import skills.IHeroVisitor;
import strategies.KnightStrategyFactory;
import strategies.StrategiesConstants;

import static characters.heroes.HeroConstants.KNIGHT_HP_LVL_UP;
import static characters.heroes.HeroConstants.KNIGHT_INITIAL_HP;
import static characters.heroes.HeroConstants.KNIGHT_RACE;

public final class Knight extends Hero {
    Knight() {
        super();
        this.race = KNIGHT_RACE;
        this.currentHp = KNIGHT_INITIAL_HP;
        this.maxHp = KNIGHT_INITIAL_HP;
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
        currentHp = KNIGHT_INITIAL_HP + currentLevel * KNIGHT_HP_LVL_UP;
        maxHp = currentHp;
    }

    @Override
    public void applyProperStrategy() {
        KnightStrategyFactory knightStrategyFactory = KnightStrategyFactory.getInstance();

        int lowerBoundHp = (int) (maxHp * StrategiesConstants.KNIGHT_LOWER_BOUND);
        int upperBoundHp = (int) (maxHp * StrategiesConstants.KNIGHT_UPPER_BOUND);

        if (upperBoundHp > currentHp && currentHp > lowerBoundHp) {
            strategy = knightStrategyFactory.createOffensiveStrategy(this);
        } else if (currentHp < lowerBoundHp) {
            strategy = knightStrategyFactory.createDefensiveStrategy(this);
        } else {
            return;
        }
        strategy.applyStrategy();
    }
}
