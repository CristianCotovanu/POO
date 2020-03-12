package skills.pyromancer;

import characters.heroes.Hero;
import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;

import map.Desert;
import map.Land;
import map.Volcanic;
import map.Woods;
import map.Terrain;
import skills.IHeroVisitor;
import skills.Skill;
import skills.effects.DamageOverTime;

import static skills.pyromancer.PyromancerConstants.IGNITE_BASE_DMG_LVL_UP;
import static skills.pyromancer.PyromancerConstants.IGNITE_DMG_PER_ROUND_LVL_UP;
import static skills.pyromancer.PyromancerConstants.IGNITE_INITIAL_DMG_PER_ROUND;
import static skills.pyromancer.PyromancerConstants.IGNITE_ROUNDS_TICK;
import static skills.pyromancer.PyromancerConstants.IGNITE_VS_ROGUE;
import static skills.pyromancer.PyromancerConstants.PYROMANCER_VOLCANIC_BONUS;

public final class Ignite extends Skill implements IHeroVisitor {
    public Ignite(final Hero caster, final Terrain terrain) {
        super(caster, terrain, PyromancerConstants.IGNITE_INITIAL_BASE_DMG);
    }

    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + PyromancerConstants.IGNITE_VS_PYROMANCER;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        pyromancer.setCurrentHp(pyromancer.getCurrentHp() - Math.round(Math.round((this.damage
                + IGNITE_BASE_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                * totalDamageModifier));

        DamageOverTime damageOverTime = new DamageOverTime(Math.round(Math.round(
                IGNITE_INITIAL_DMG_PER_ROUND + IGNITE_DMG_PER_ROUND_LVL_UP * caster.getLevel()
                * terrainModifier) * totalDamageModifier), IGNITE_ROUNDS_TICK);

        pyromancer.setDamageOverTime(damageOverTime);
    }

    @Override
    public void applyEffect(final Knight knight) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + PyromancerConstants.IGNITE_VS_KNIGHT;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        knight.setCurrentHp(knight.getCurrentHp() - Math.round(Math.round((this.damage
                + IGNITE_BASE_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                * totalDamageModifier));

        DamageOverTime damageOverTime = new DamageOverTime(Math.round(Math.round(
                IGNITE_INITIAL_DMG_PER_ROUND + IGNITE_DMG_PER_ROUND_LVL_UP * caster.getLevel()
                * terrainModifier) * totalDamageModifier), IGNITE_ROUNDS_TICK);
        knight.setDamageOverTime(damageOverTime);
    }

    @Override
    public void applyEffect(final Rogue rogue) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + IGNITE_VS_ROGUE;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        rogue.setCurrentHp(rogue.getCurrentHp() - Math.round(
                Math.round((this.damage + IGNITE_BASE_DMG_LVL_UP
                * caster.getLevel()) * terrainModifier) * totalDamageModifier));

        DamageOverTime damageOverTime = new DamageOverTime(Math.round(Math.round(
                IGNITE_INITIAL_DMG_PER_ROUND + IGNITE_DMG_PER_ROUND_LVL_UP * caster.getLevel()
                * terrainModifier) * totalDamageModifier), IGNITE_ROUNDS_TICK);

        rogue.setDamageOverTime(damageOverTime);
    }

    @Override
    public void applyEffect(final Wizard wizard) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + PyromancerConstants.IGNITE_VS_WIZARD;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        wizard.setCurrentHp(wizard.getCurrentHp() - Math.round(Math.round((this.damage
                + IGNITE_BASE_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                * totalDamageModifier));

        DamageOverTime damageOverTime = new DamageOverTime(Math.round(Math.round(
                IGNITE_INITIAL_DMG_PER_ROUND + IGNITE_DMG_PER_ROUND_LVL_UP * caster.getLevel()
                * terrainModifier) * totalDamageModifier), IGNITE_ROUNDS_TICK);

        wizard.setDamageOverTime(damageOverTime);
    }

    @Override
    public float visitTerrain(final Volcanic volcanic) {
        return PYROMANCER_VOLCANIC_BONUS;
    }

    @Override
    public float visitTerrain(final Land land) {
        return 0;
    }

    @Override
    public float visitTerrain(final Woods woods) {
        return 0;
    }

    @Override
    public float visitTerrain(final Desert desert) {
        return 0;
    }
}
