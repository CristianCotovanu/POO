package map;

import characters.heroes.Hero;

import java.util.List;

public final class MoveHero {
    private Terrain[][] battlefield;
    private List<Hero> heroes;
    private List<String> movesThisGame;

    public MoveHero(final Terrain[][] battlefield,
                    final List<Hero> heroes, final List<String> movesThisGame) {
        this.battlefield = battlefield;
        this.heroes = heroes;
        this.movesThisGame = movesThisGame;
    }

    public void moveHeroesPerRound(final String roundMoves) {
        for (int i = 0; i < roundMoves.length(); i++) {
            String move = roundMoves.substring(i, i + 1);
            if (!heroes.get(i).isDead()) {
                moveHeroOnMap(heroes.get(i), move);
            }
        }
    }

    private void moveHeroOnMap(final Hero hero, final String move) {
        Terrain currentTile = battlefield[hero.getPosX()][hero.getPosY()];

        if (hero.isStunned() || move.equals("_")) {
            return;
        } else if (move.equals("R")) {
            int newX = hero.getPosX();
            int newY = hero.getPosY() + 1;

            if (newY == battlefield[0].length) {
                return;
            }

            hero.setPosY(newY);
            currentTile.removeHero(hero);
            battlefield[newX][newY].addHero(hero);
        } else if (move.equals("L")) {
            int newX = hero.getPosX();
            int newY = hero.getPosY() - 1;

            if (newY < 0) {
                return;
            }

            hero.setPosY(newY);
            currentTile.removeHero(hero);
            battlefield[newX][newY].addHero(hero);
        } else if (move.equals("U")) {
            int newX = hero.getPosX() - 1;
            int newY = hero.getPosY();

            if (newX < 0) {
                return;
            }

            hero.setPosX(newX);
            currentTile.removeHero(hero);
            battlefield[newX][newY].addHero(hero);
        } else if (move.equals("D")) {
            int newX = hero.getPosX() + 1;
            int newY = hero.getPosY();

            if (newX == battlefield.length) {
                return;
            }

            hero.setPosX(newX);
            currentTile.removeHero(hero);
            battlefield[newX][newY].addHero(hero);
        }
    }

    public List<String> getMovesThisGame() {
        return movesThisGame;
    }
}
