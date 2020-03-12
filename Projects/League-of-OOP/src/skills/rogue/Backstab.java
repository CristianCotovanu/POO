package skills.rogue;

import game.GameEngine;
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

import static skills.rogue.RogueConstants.BACKSTAB_DMG_LVL_UP;
import static skills.rogue.RogueConstants.BACKSTAB_INITIAL_DMG;
import static skills.rogue.RogueConstants.BACKSTAB_VS_PYROMANCER;
import static skills.rogue.RogueConstants.BACKSTAB_VS_ROGUE;
import static skills.rogue.RogueConstants.BACKSTAB_VS_KNIGHT;
import static skills.rogue.RogueConstants.BACKSTAB_VS_WIZARD;
import static skills.rogue.RogueConstants.LUCKY_CRIT_ROUND;
import static skills.rogue.RogueConstants.ROGUE_CRIT_BONUS;
import static skills.rogue.RogueConstants.ROGUE_WOODS_BONUS;

public final class Backstab extends Skill {
    public Backstab(final Hero caster, final Terrain terrain) {
        super(caster, terrain, BACKSTAB_INITIAL_DMG);
    }

    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + BACKSTAB_VS_PYROMANCER;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        if (terrainModifier != 1 && GameEngine.getRoundNumber() % LUCKY_CRIT_ROUND == 0) {
            pyromancer.setCurrentHp(pyromancer.getCurrentHp() - Math.round(Math.round((this.damage
                    + BACKSTAB_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier * ROGUE_CRIT_BONUS));
        } else {
            pyromancer.setCurrentHp(pyromancer.getCurrentHp() - Math.round(Math.round((this.damage
                    + BACKSTAB_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier));
        }
    }

    @Override
    public void applyEffect(final Knight knight) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + BACKSTAB_VS_KNIGHT;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        if (terrainModifier != 1 && GameEngine.getRoundNumber() % LUCKY_CRIT_ROUND == 0) {
            knight.setCurrentHp(knight.getCurrentHp() - Math.round(Math.round((this.damage
                    + BACKSTAB_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier * ROGUE_CRIT_BONUS));
        } else {
            knight.setCurrentHp(knight.getCurrentHp() - Math.round(Math.round((this.damage
                    + BACKSTAB_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier));
        }
    }

    @Override
    public void applyEffect(final Rogue rogue) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + BACKSTAB_VS_ROGUE;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        if (terrainModifier != 1 && GameEngine.getRoundNumber() % LUCKY_CRIT_ROUND == 0) {
            rogue.setCurrentHp(rogue.getCurrentHp() - Math.round(Math.round((this.damage
                    + BACKSTAB_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier * ROGUE_CRIT_BONUS));
        } else {
            rogue.setCurrentHp(rogue.getCurrentHp() - Math.round(Math.round((this.damage
                    + BACKSTAB_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier));
        }
    }

    @Override
    public void applyEffect(final Wizard wizard) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + BACKSTAB_VS_WIZARD;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        if (terrainModifier != 1 && GameEngine.getRoundNumber() % LUCKY_CRIT_ROUND == 0) {
            wizard.setCurrentHp(wizard.getCurrentHp() - Math.round(Math.round((this.damage
                    + BACKSTAB_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier * ROGUE_CRIT_BONUS));
        } else {
            wizard.setCurrentHp(wizard.getCurrentHp() - Math.round(Math.round((this.damage
                    + BACKSTAB_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier));
        }
    }

    @Override
    public float visitTerrain(final Volcanic volcanic) {
        return 0;
    }

    @Override
    public float visitTerrain(final Land land) {
        return 0;
    }

    @Override
    public float visitTerrain(final Woods woods) {
        return ROGUE_WOODS_BONUS;
    }

    @Override
    public float visitTerrain(final Desert desert) {
        return 0;
    }
}
