package map;

public final class TerrainFactory {
    private static TerrainFactory instance = null;

    private TerrainFactory() { }

    public Terrain createTerrain(final String type) {
        switch (type) {
            case TerrainConstants.VOLCANIC_TYPE:
                return new Volcanic();
            case TerrainConstants.LAND_TYPE:
                return new Land();
            case TerrainConstants.WOODS_TYPE:
                return new Woods();
            case TerrainConstants.DESERT_TYPE:
                return new Desert();
            default:
                return null;
        }
    }

    public static TerrainFactory getInstance() {
        if (instance == null) {
            instance = new TerrainFactory();
        }
        return instance;
    }
}
