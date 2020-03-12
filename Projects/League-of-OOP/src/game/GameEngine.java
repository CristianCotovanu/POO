package game;

import characters.heroes.Hero;
import characters.heroes.HeroFactory;
import fileio.GameInput;
import fileio.WriteFile;
import map.GameMap;
import map.MoveHero;
import map.Terrain;
import skills.effects.DamageOverTime;
import skills.effects.Stun;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class GameEngine {
    private GameMap map;
    private List<Hero> heroesList;
    private static int roundNumber;
    private MoveHero moveHero;
    private AngelsController angelsController;
    private WriteFile writeFile;

    public GameEngine(final GameInput gameInput, final WriteFile writeFile) {
        heroesList = new ArrayList<>();
        instantiatePlayers(gameInput.getPlayerRaceAndPosition());
        map = GameMap.getInstance(gameInput.getLandTypesPerRow(), gameInput.getMapRows(),
                gameInput.getMapCols(), heroesList);
        moveHero = new MoveHero(map.getBattlefield(), heroesList, gameInput.getMovesForRound());
        angelsController = new AngelsController(gameInput.getAngelsForRound());
        this.writeFile = writeFile;
    }

    public void start() {
        for (String roundMove : moveHero.getMovesThisGame()) {
            writeFile.writeRound(roundNumber);
            moveHero.moveHeroesPerRound(roundMove);
            Terrain[][] battlefield = map.getBattlefield();

            for (Terrain[] terrains : battlefield) {
                for (Terrain terrain : terrains) {
                    ArrayList<Hero> heroesOnTile = terrain.getHeroesOnTerrain();

                    applyDoTOnHeroes(heroesOnTile);
                    heroesUseStrategies(heroesOnTile);
                    applyStunToHeroes(heroesOnTile);
                    eliminateDeadPlayersFromMap(map.getBattlefield());
                }
            }

            for (Hero hero1 : heroesList) {
                for (Hero hero2 : heroesList) {
                    if (hero1.getPosX() == hero2.getPosX()
                            && hero2.getPosY() == hero1.getPosY()
                            && !hero1.equals(hero2)
                            && !battlefield[hero1.getPosX()][hero1.getPosY()].isFoughtOn()) {

                        Terrain terrain = map.getBattlefield()[hero2.getPosX()][hero2.getPosY()];
                        ArrayList<Hero> heroesOnTile = terrain.getHeroesOnTerrain();

                        if (heroesOnTile.size() < 2) {
                            continue;
                        }

                        terrain.setFoughtOn(true);
                        heroesOnTileFight(terrain, heroesOnTile);
                    }
                }
            }

            clearFoughtOn(battlefield);

            eliminateDeadPlayersFromMap(battlefield);
            angelsController.instantiateAngels(roundNumber, map.getBattlefield());
            angelsController.angelsLeaveTheBattlefield(map.getBattlefield());
            reviveDeadPlayers(map.getBattlefield());
            roundNumber++;
            writeFile.writeNewline();
        }
    }

    private void clearFoughtOn(final Terrain[][] battlefield) {
        for (Terrain[] terrains : battlefield) {
            for (Terrain terrain : terrains) {
                terrain.setFoughtOn(false);
            }
        }
    }

    private void heroesOnTileFight(final Terrain terrain, final ArrayList<Hero> heroesOnTile) {
        for (int i = 0; i < heroesOnTile.size(); i++) {
            for (int j = i; j < heroesOnTile.size(); j++) {
                if (i != j) {
                    Fight fight = new Fight(heroesOnTile.get(i), heroesOnTile.get(j));
                    fight.startFight(terrain);
                }
            }
        }
    }

    static void reviveDeadPlayers(final Terrain[][] battlefield) {
        for (Terrain[] terrains : battlefield) {
            for (Terrain terrain : terrains) {
                ArrayList<Hero> heroesOnTerrain = terrain.getHeroesOnTerrain();
                ArrayList<Hero> deadHeroesOnTerrain = terrain.getDeadHeroesOnTerrain();

                Iterator iterator = deadHeroesOnTerrain.iterator();
                while (iterator.hasNext()) {
                    Hero currentHero = (Hero) iterator.next();
                    if (!currentHero.isDead()) {
                        heroesOnTerrain.add(currentHero);
                        iterator.remove();
                    }
                }
            }
        }
    }

    private void heroesUseStrategies(final List<Hero> heroes) {
        for (Hero hero : heroes) {
            if (!hero.isDead()) {
                hero.useStrategy();
            }
        }
    }

    static void eliminateDeadPlayersFromMap(final Terrain[][] battlefield) {
        for (Terrain[] terrains : battlefield) {
            for (Terrain terrain : terrains) {
                ArrayList<Hero> heroesOnTerrain = terrain.getHeroesOnTerrain();
                ArrayList<Hero> deadHeroesOnTerrain = terrain.getDeadHeroesOnTerrain();

                Iterator iterator = heroesOnTerrain.iterator();
                while (iterator.hasNext()) {
                    Hero currentHero = (Hero) iterator.next();
                    if (currentHero.isDead()) {
                        deadHeroesOnTerrain.add(currentHero);
                        iterator.remove();
                    }
                }
            }
        }
    }

    private void applyDoTOnHeroes(final List<Hero> heroes) {
        for (Hero hero : heroes) {
            applyDoT(hero);
        }
    }

    private void applyDoT(final Hero hero) {
        DamageOverTime damageOverTime = hero.getDamageOverTime();
        if (damageOverTime.getRounds() > 0) {
            damageOverTime.setRounds(damageOverTime.getRounds() - 1);
            hero.setCurrentHp(hero.getCurrentHp() - Math.round(damageOverTime.getDamagePerRound()));
        }
    }

    private void applyStunToHeroes(final List<Hero> heroes) {
        for (Hero hero : heroes) {
            Stun stun = hero.getStun();
            if (stun.getRounds() > 0) {
                stun.setRounds(stun.getRounds() - 1);
            }
        }
    }

    private void instantiatePlayers(final List<String> playersRaceAndPosition) {
        HeroFactory heroFactory = HeroFactory.getInstance();
        int heroCounter = 0;

        for (String string : playersRaceAndPosition) {
            String[] tokens = string.split(" ");

            Hero newHero = heroFactory.createHero(tokens[0]);
            int coordX = Integer.parseInt(tokens[1]);
            int coordY = Integer.parseInt(tokens[2]);

            newHero.setPosX(coordX);
            newHero.setPosY(coordY);
            newHero.setInitialPosition(heroCounter);
            heroCounter++;
            heroesList.add(newHero);
        }
    }

    public List<Hero> getHeroesList() {
        return heroesList;
    }

    public static int getRoundNumber() {
        return roundNumber;
    }
}
