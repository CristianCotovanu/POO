package characters.heroes;

import characters.angels.IAngelVisitorToHero;
import skills.IHeroVisitor;
import strategies.StrategiesConstants;
import strategies.WizardStrategyFactory;

import static characters.heroes.HeroConstants.WIZARD_HP_LVL_UP;
import static characters.heroes.HeroConstants.WIZARD_INITIAL_HP;
import static characters.heroes.HeroConstants.WIZARD_RACE;

public final class Wizard extends Hero {
    Wizard() {
        super();
        this.race = WIZARD_RACE;
        this.currentHp = WIZARD_INITIAL_HP;
        this.maxHp = WIZARD_INITIAL_HP;
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
        currentHp = WIZARD_INITIAL_HP + currentLevel * WIZARD_HP_LVL_UP;
        maxHp = currentHp;
    }

    @Override
    public void applyProperStrategy() {
        WizardStrategyFactory wizardStrategyFactory = WizardStrategyFactory.getInstance();

        int lowerBoundHp = (int) (maxHp * StrategiesConstants.WIZARD_LOWER_BOUND);
        int upperBoundHp = (int) (maxHp * StrategiesConstants.WIZARD_UPPER_BOUND);

        if (upperBoundHp > currentHp && currentHp > lowerBoundHp) {
            strategy = wizardStrategyFactory.createOffensiveStrategy(this);
        } else if (currentHp < lowerBoundHp) {
            strategy = wizardStrategyFactory.createDefensiveStrategy(this);
        } else {
            return;
        }
        strategy.applyStrategy();
    }
}
