package characters.heroes;

import characters.angels.IAngelVisitorToHero;
import skills.IHeroVisitor;
import strategies.PyromancerStrategyFactory;
import strategies.StrategiesConstants;

import static characters.heroes.HeroConstants.PYROMANCER_HP_LVL_UP;
import static characters.heroes.HeroConstants.PYROMANCER_INITIAL_HP;
import static characters.heroes.HeroConstants.PYROMANCER_RACE;

public final class Pyromancer extends Hero {
    Pyromancer() {
        super();
        this.race = PYROMANCER_RACE;
        this.currentHp = PYROMANCER_INITIAL_HP;
        this.maxHp = PYROMANCER_INITIAL_HP;
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
        currentHp = PYROMANCER_INITIAL_HP + currentLevel * PYROMANCER_HP_LVL_UP;
        maxHp = currentHp;
    }

    @Override
    public void applyProperStrategy() {
        PyromancerStrategyFactory pyromancerStrategyFactory
                = PyromancerStrategyFactory.getInstance();

        int lowerBoundHp = (int) (maxHp * StrategiesConstants.PYRO_LOWER_BOUND);
        int upperBoundHp = (int) (maxHp * StrategiesConstants.PYRO_UPPER_BOUND);

        if (upperBoundHp > currentHp && currentHp > lowerBoundHp) {
            strategy = pyromancerStrategyFactory.createOffensiveStrategy(this);
        } else if (currentHp < lowerBoundHp) {
            strategy = pyromancerStrategyFactory.createDefensiveStrategy(this);
        } else {
            return;
        }
        strategy.applyStrategy();
    }
}
