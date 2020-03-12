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
import skills.Skill;

import static skills.pyromancer.PyromancerConstants.FIREBLAST_DMG_LVL_UP;
import static skills.pyromancer.PyromancerConstants.FIREBLAST_INITIAL_DMG;
import static skills.pyromancer.PyromancerConstants.FIREBLAST_VS_KNIGHT;
import static skills.pyromancer.PyromancerConstants.FIREBLAST_VS_PYROMANCER;
import static skills.pyromancer.PyromancerConstants.FIREBLAST_VS_WIZARD;
import static skills.pyromancer.PyromancerConstants.FIREBLAST_VS_ROGUE;
import static skills.pyromancer.PyromancerConstants.PYROMANCER_VOLCANIC_BONUS;

public final class Fireblast extends Skill {

    public Fireblast(final Hero caster, final Terrain terrain) {
        super(caster, terrain, FIREBLAST_INITIAL_DMG);
    }

    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + FIREBLAST_VS_PYROMANCER;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        pyromancer.setCurrentHp(pyromancer.getCurrentHp() - Math.round(Math.round((this.damage
                + FIREBLAST_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                * totalDamageModifier));
    }

    @Override
    public void applyEffect(final Knight knight) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + FIREBLAST_VS_KNIGHT;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        knight.setCurrentHp(knight.getCurrentHp() - Math.round(Math.round((this.damage
                + FIREBLAST_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                * totalDamageModifier));
    }

    @Override
    public void applyEffect(final Rogue rogue) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + FIREBLAST_VS_ROGUE;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        rogue.setCurrentHp(rogue.getCurrentHp() - Math.round(Math.round((this.damage
                + FIREBLAST_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                * totalDamageModifier));
    }

    @Override
    public void applyEffect(final Wizard wizard) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + FIREBLAST_VS_WIZARD;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        wizard.setCurrentHp(wizard.getCurrentHp() - Math.round(Math.round((this.damage
                + FIREBLAST_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                * totalDamageModifier));
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
