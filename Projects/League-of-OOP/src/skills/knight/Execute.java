package skills.knight;

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

import static skills.knight.KnightConstants.EXECUTE_DMG_LVL_UP;
import static skills.knight.KnightConstants.EXECUTE_INITIAL_HP_LIMIT;
import static skills.knight.KnightConstants.EXECUTE_INITIAL_DMG;
import static skills.knight.KnightConstants.EXECUTE_MAX_LIMIT_PERCENTAGE;
import static skills.knight.KnightConstants.EXECUTE_VS_PYROMANCER;
import static skills.knight.KnightConstants.EXECUTE_VS_WIZARD;
import static skills.knight.KnightConstants.EXECUTE_VS_ROGUE;
import static skills.knight.KnightConstants.EXECUTE_HP_LIMIT_LVL_UP;
import static skills.knight.KnightConstants.KNIGHT_LAND_BONUS;

public final class Execute extends Skill {
    public Execute(final Hero caster, final Terrain terrain) {
        super(caster, terrain, EXECUTE_INITIAL_DMG);
    }

    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + EXECUTE_VS_PYROMANCER;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        float victimHp = pyromancer.getCurrentHp();
        float executeLimitPercentage = EXECUTE_INITIAL_HP_LIMIT
                                        + caster.getLevel() * EXECUTE_HP_LIMIT_LVL_UP;

        if (executeLimitPercentage > EXECUTE_MAX_LIMIT_PERCENTAGE) {
            executeLimitPercentage = EXECUTE_MAX_LIMIT_PERCENTAGE;
        }

        if (victimHp < executeLimitPercentage * pyromancer.getMaxHp()) {
            pyromancer.setCurrentHp(0);
        } else {
            pyromancer.setCurrentHp(pyromancer.getCurrentHp() - Math.round(Math.round((this.damage
                    + EXECUTE_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier));
        }
    }

    @Override
    public void applyEffect(final Knight knight) {
        float terrainModifier = getTerrainModifier();

        float victimHp = knight.getCurrentHp();
        float executeLimitPercentage = EXECUTE_INITIAL_HP_LIMIT
                                        + caster.getLevel() * EXECUTE_HP_LIMIT_LVL_UP;

        if (executeLimitPercentage > EXECUTE_MAX_LIMIT_PERCENTAGE) {
            executeLimitPercentage = EXECUTE_MAX_LIMIT_PERCENTAGE;
        }

        if (victimHp < executeLimitPercentage * knight.getMaxHp()) {
            knight.setCurrentHp(0);
        } else {
            knight.setCurrentHp(knight.getCurrentHp() - Math.round((this.damage
                    + EXECUTE_DMG_LVL_UP * caster.getLevel()) * terrainModifier));
        }
    }

    @Override
    public void applyEffect(final Rogue rogue) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + EXECUTE_VS_ROGUE;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        float victimHp = rogue.getCurrentHp();
        float executeLimitPercentage = EXECUTE_INITIAL_HP_LIMIT
                                        + caster.getLevel() * EXECUTE_HP_LIMIT_LVL_UP;

        if (executeLimitPercentage > EXECUTE_MAX_LIMIT_PERCENTAGE) {
            executeLimitPercentage = EXECUTE_MAX_LIMIT_PERCENTAGE;
        }

        if (victimHp < executeLimitPercentage * rogue.getMaxHp()) {
            rogue.setCurrentHp(0);
        } else {
            rogue.setCurrentHp(rogue.getCurrentHp() - Math.round(Math.round((this.damage
                    + EXECUTE_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier));
        }
    }

    @Override
    public void applyEffect(final Wizard wizard) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + EXECUTE_VS_WIZARD;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        float victimHp = wizard.getCurrentHp();
        float executeLimitPercentage = EXECUTE_INITIAL_HP_LIMIT
                                        + caster.getLevel() * EXECUTE_HP_LIMIT_LVL_UP;

        if (executeLimitPercentage > EXECUTE_MAX_LIMIT_PERCENTAGE) {
            executeLimitPercentage = EXECUTE_MAX_LIMIT_PERCENTAGE;
        }

        if (victimHp < executeLimitPercentage * wizard.getMaxHp()) {
            wizard.setCurrentHp(0);
        } else {
            wizard.setCurrentHp(wizard.getCurrentHp() - Math.round(Math.round((this.damage
                    + EXECUTE_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier));
        }
    }

    @Override
    public float visitTerrain(final Volcanic volcanic) {
        return 0;
    }

    @Override
    public float visitTerrain(final Land land) {
        return KNIGHT_LAND_BONUS;
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
