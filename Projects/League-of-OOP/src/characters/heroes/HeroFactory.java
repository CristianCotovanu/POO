package characters.heroes;

public final class HeroFactory {
    private static HeroFactory instance = null;

    private HeroFactory() { }

    public Hero createHero(final String race) {
        switch (race) {
            case HeroConstants.PYROMANCER_RACE:
                return new Pyromancer();
            case HeroConstants.KNIGHT_RACE:
                return new Knight();
            case HeroConstants.ROGUE_RACE:
                return new Rogue();
            case HeroConstants.WIZARD_RACE:
                return new Wizard();
            default:
                return null;
        }
    }

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }
}
