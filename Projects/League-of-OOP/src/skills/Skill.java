package skills;

import characters.heroes.Hero;
import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import map.Terrain;
import map.Volcanic;
import map.Land;
import map.Woods;
import map.Desert;

public abstract class Skill implements IHeroVisitor, ITerrainVisitor {
    protected Hero caster;
    protected Terrain terrain;
    protected int damage;

    public Skill(final Hero caster, final Terrain terrain, final int damage) {
        this.caster = caster;
        this.terrain = terrain;
        this.damage = damage;
    }

    protected final float getTerrainModifier() {
        return 1 + terrain.acceptSkill(this);
    }

    /**
     * @param pyromancer type of player visited
     */
    @Override
    public void applyEffect(final Pyromancer pyromancer) {

    }

    /**
     * @param knight type of player visited
     */
    @Override
    public void applyEffect(final Knight knight) {

    }

    /**
     * @param rogue type of player visited
     */
    @Override
    public void applyEffect(final Rogue rogue) {

    }

    /**
     * @param wizard type of player visited
     */
    @Override
    public void applyEffect(final Wizard wizard) {

    }

    /**
     * @param volcanic type of terrain visited
     * @return the bonus for a skill the terrain provides
     */
    @Override
    public float visitTerrain(final Volcanic volcanic) {
        return 0;
    }

    /**
     * @param land type of terrain visited
     * @return the bonus for a skill the terrain provides
     */
    @Override
    public float visitTerrain(final Land land) {
        return 0;
    }

    /**
     * @param woods type of terrain visited
     * @return the bonus for a skill the terrain provides
     */
    @Override
    public float visitTerrain(final Woods woods) {
        return 0;
    }

    /**
     * @param desert type of terrain visited
     * @return the bonus for a skill the terrain provides
     */
    @Override
    public float visitTerrain(final Desert desert) {
        return 0;
    }

}
