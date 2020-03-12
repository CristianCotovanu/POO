package characters.angels;

public final class AngelFactory {
    private static AngelFactory instance = null;

    private AngelFactory() { }

    public Angel createAngel(final AngelType type, final int posX,
                             final int posY) {
        switch (type) {
            case DamageAngel:
                return new DamageAngel(posX, posY);
            case DarkAngel:
                return new DarkAngel(posX, posY);
            case Dracula:
                return new Dracula(posX, posY);
            case GoodBoy:
                return new GoodBoy(posX, posY);
            case LevelUpAngel:
                return new LevelUpAngel(posX, posY);
            case LifeGiver:
                return new LifeGiver(posX, posY);
            case SmallAngel:
                return new SmallAngel(posX, posY);
            case Spawner:
                return new Spawner(posX, posY);
            case TheDoomer:
                return new TheDoomer(posX, posY);
            case XPAngel:
                return new XPAngel(posX, posY);
            default:
                return null;
        }
    }

    public static AngelFactory getInstance() {
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }
}
