package game;

import characters.angels.Angel;
import characters.angels.AngelFactory;
import characters.angels.AngelType;
import characters.angels.Spawner;
import characters.heroes.Hero;
import grandmagician.GrandMagician;
import grandmagician.Observable;
import map.Terrain;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

final class AngelsController extends Observable {
    private List<String> angelsForEveryRound;

    AngelsController(final List<String> angelsForRound) {
        super(GrandMagician.getInstance());
        angelsForEveryRound = angelsForRound;
    }

    void instantiateAngels(final int roundNumber, final Terrain[][] battlefield) {
        AngelFactory angelFactory = AngelFactory.getInstance();
        String[] angelsParameters = angelsForEveryRound.get(roundNumber).split(" ");

        for (String angel : angelsParameters) {
            String[] parameters = angel.split(",");

            if (parameters[0].equals("0")) {
                continue;
            }

            AngelType angelType = AngelType.valueOf(parameters[0]);
            int angelCoordX = Integer.parseInt(parameters[1]);
            int angelCoordY = Integer.parseInt(parameters[2]);

            Angel newAngel = angelFactory.createAngel(angelType, angelCoordX, angelCoordY);

            assert newAngel != null;
            battlefield[newAngel.getPosX()][newAngel.getPosY()].addAngel(newAngel);

            angelBlessHeroes(battlefield, newAngel.getPosX(), newAngel.getPosY());
        }
    }

    private void angelBlessHeroes(final Terrain[][] battlefield, final int angelPosX,
                                  final int angelPosY) {
        Terrain terrain = battlefield[angelPosX][angelPosY];
        List<Angel> angelsOnTerrain = terrain.getAngelsOnTerrain();
        List<Hero> heroesOnTerrain = terrain.getHeroesOnTerrain();
        List<Hero> deadHeroesOnTerrain = terrain.getDeadHeroesOnTerrain();
        heroesOnTerrain.sort(Comparator.comparing(Hero::getInitialPosition));

        Iterator angelsIterator = angelsOnTerrain.iterator();

        while (angelsIterator.hasNext()) {
            Angel angel = (Angel) angelsIterator.next();

            if (angel instanceof Spawner) {
                for (Hero hero : deadHeroesOnTerrain) {
                    if (hero.isDead()) {
                        hero.acceptAngel(angel);
                    }
                }
                GameEngine.reviveDeadPlayers(battlefield);
            } else {
                for (Hero hero : heroesOnTerrain) {
                    hero.acceptAngel(angel);
                }
            }
            angelsIterator.remove();
            GameEngine.eliminateDeadPlayersFromMap(battlefield);
        }
    }

    void angelsLeaveTheBattlefield(final Terrain[][] battlefield) {
        for (Terrain[] terrainColumn : battlefield) {
            for (Terrain terrain : terrainColumn) {
                Iterator angelsIterator = terrain.getAngelsOnTerrain().iterator();

                while (angelsIterator.hasNext()) {
                    angelsIterator.next();
                    angelsIterator.remove();
                }
            }
        }
    }
}
