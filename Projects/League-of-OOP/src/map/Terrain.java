package map;

import characters.angels.Angel;
import characters.heroes.Hero;
import skills.ITerrainVisitor;

import java.util.ArrayList;

public abstract class Terrain {
    private ArrayList<Hero> heroesOnTerrain;
    private ArrayList<Hero> deadHeroesOnTerrain;
    private ArrayList<Angel> angelsOnTerrain;
    private boolean foughtOn = false;

    protected Terrain() {
        heroesOnTerrain = new ArrayList<>();
        deadHeroesOnTerrain = new ArrayList<>();
        angelsOnTerrain = new ArrayList<>();
    }

    public abstract float acceptSkill(ITerrainVisitor skill);

    final void addHero(final Hero hero) {
        heroesOnTerrain.add(hero);
    }

    final void removeHero(final Hero hero) {
        heroesOnTerrain.remove(hero);
    }

    public final void addAngel(final Angel angel) {
        angelsOnTerrain.add(angel);
    }

    public final ArrayList<Hero> getHeroesOnTerrain() {
        return heroesOnTerrain;
    }

    public final ArrayList<Hero> getDeadHeroesOnTerrain() {
        return deadHeroesOnTerrain;
    }

    public final ArrayList<Angel> getAngelsOnTerrain() {
        return angelsOnTerrain;
    }

    public final boolean isFoughtOn() {
        return foughtOn;
    }

    public final void setFoughtOn(final boolean foughtOn) {
        this.foughtOn = foughtOn;
    }
}
