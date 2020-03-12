package map;

import characters.heroes.Hero;

import java.util.List;

public final class GameMap {
    private static GameMap instance = null;
    private Terrain[][] battlefield;

    private GameMap(final List<String> landTypesPerRow, final int rows, final int cols,
                    final List<Hero> heroes) {
        battlefield = new Terrain[rows][cols];
        initializeMap(landTypesPerRow, rows, cols);
        initializePlayersOnMap(heroes);
    }

    private void initializeMap(final List<String> landTypesPerRow,
                               final int rows, final int cols) {
        TerrainFactory terrainFactory = TerrainFactory.getInstance();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String type = landTypesPerRow.get(i).substring(j, j + 1);
                battlefield[i][j] = terrainFactory.createTerrain(type);
            }
        }
    }

    private void initializePlayersOnMap(final List<Hero> heroes) {
        for (Hero hero : heroes) {
            battlefield[hero.getPosX()][hero.getPosY()].addHero(hero);
        }
    }

    public static GameMap getInstance(final List<String> landTypesPerRow,
                                      final int rows, final int cols, final List<Hero> heroes) {
        if (instance == null) {
            instance = new GameMap(landTypesPerRow, rows, cols, heroes);
        }
        return instance;
    }

    public Terrain[][] getBattlefield() {
        return battlefield;
    }
}
