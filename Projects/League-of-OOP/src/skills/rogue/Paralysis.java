package skills.rogue;

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
import skills.effects.DamageOverTime;
import skills.effects.Stun;

import static skills.rogue.RogueConstants.PARALYSIS_INITIAL_DMG;
import static skills.rogue.RogueConstants.PARALYSIS_DMG_LVL_UP;
import static skills.rogue.RogueConstants.PARALYSIS_ROUNDS_TICK;
import static skills.rogue.RogueConstants.PARALYSIS_ROUNDS_TICK_WOODS;
import static skills.rogue.RogueConstants.PARALYSIS_VS_PYROMANCER;
import static skills.rogue.RogueConstants.PARALYSIS_VS_KNIGHT;
import static skills.rogue.RogueConstants.PARALYSIS_VS_ROGUE;
import static skills.rogue.RogueConstants.PARALYSIS_VS_WIZARD;
import static skills.rogue.RogueConstants.ROGUE_WOODS_BONUS;

public final class Paralysis extends Skill {
    public Paralysis(final Hero caster, final Terrain terrain) {
        super(caster, terrain, PARALYSIS_INITIAL_DMG);
    }

    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + PARALYSIS_VS_PYROMANCER;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        DamageOverTime damageOverTime;
        Stun stun;
        pyromancer.setCurrentHp(pyromancer.getCurrentHp() - Math.round(Math.round((this.damage
                + PARALYSIS_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                * totalDamageModifier));

        if (terrainModifier != 1) {
            damageOverTime = new DamageOverTime(Math.round(Math.round((this.damage
                    + PARALYSIS_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier), PARALYSIS_ROUNDS_TICK_WOODS);

            stun = new Stun(PARALYSIS_ROUNDS_TICK_WOODS);
        } else {
            damageOverTime = new DamageOverTime(Math.round(Math.round((this.damage
                    + PARALYSIS_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier), PARALYSIS_ROUNDS_TICK);
            stun = new Stun(PARALYSIS_ROUNDS_TICK);
        }

        pyromancer.setStun(stun);
        pyromancer.setDamageOverTime(damageOverTime);
    }

    @Override
    public void applyEffect(final Knight knight) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + PARALYSIS_VS_KNIGHT;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        DamageOverTime damageOverTime;
        Stun stun;
        knight.setCurrentHp(knight.getCurrentHp() - Math.round(Math.round((this.damage
                + PARALYSIS_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                * totalDamageModifier));

        if (terrainModifier != 1) {
            damageOverTime = new DamageOverTime(Math.round(Math.round((this.damage
                    + PARALYSIS_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier), PARALYSIS_ROUNDS_TICK_WOODS);
            stun = new Stun(PARALYSIS_ROUNDS_TICK_WOODS);
        } else {
            damageOverTime = new DamageOverTime(Math.round(Math.round((this.damage
                    + PARALYSIS_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier),
                    PARALYSIS_ROUNDS_TICK);
            stun = new Stun(PARALYSIS_ROUNDS_TICK);
        }

        knight.setStun(stun);
        knight.setDamageOverTime(damageOverTime);
    }

    @Override
    public void applyEffect(final Rogue rogue) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + PARALYSIS_VS_ROGUE;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        DamageOverTime damageOverTime;
        Stun stun;
        rogue.setCurrentHp(rogue.getCurrentHp() - Math.round(Math.round((this.damage
                + PARALYSIS_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                * totalDamageModifier));

        if (terrainModifier != 1) {
            damageOverTime = new DamageOverTime(Math.round(Math.round((this.damage
                    + PARALYSIS_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier), PARALYSIS_ROUNDS_TICK_WOODS);
            stun = new Stun(PARALYSIS_ROUNDS_TICK_WOODS);
        } else {
            damageOverTime = new DamageOverTime(Math.round(Math.round((this.damage
                    + PARALYSIS_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier), PARALYSIS_ROUNDS_TICK);
            stun = new Stun(PARALYSIS_ROUNDS_TICK);
        }

        rogue.setStun(stun);
        rogue.setDamageOverTime(damageOverTime);
    }

    @Override
    public void applyEffect(final Wizard wizard) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + PARALYSIS_VS_WIZARD;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        DamageOverTime damageOverTime;
        Stun stun;
        wizard.setCurrentHp(wizard.getCurrentHp() - Math.round(Math.round((this.damage
                + PARALYSIS_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                * totalDamageModifier));

        if (terrainModifier != 1) {
            damageOverTime = new DamageOverTime(Math.round(Math.round((this.damage
                    + PARALYSIS_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier), PARALYSIS_ROUNDS_TICK_WOODS);
            stun = new Stun(PARALYSIS_ROUNDS_TICK_WOODS);
        } else {
            damageOverTime = new DamageOverTime(Math.round(Math.round((this.damage
                    + PARALYSIS_DMG_LVL_UP * caster.getLevel()) * terrainModifier)
                    * totalDamageModifier), PARALYSIS_ROUNDS_TICK);
            stun = new Stun(PARALYSIS_ROUNDS_TICK);
        }

        wizard.setStun(stun);
        wizard.setDamageOverTime(damageOverTime);
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
