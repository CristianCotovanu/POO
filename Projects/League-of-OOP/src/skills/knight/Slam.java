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
import skills.effects.DamageOverTime;
import skills.effects.Stun;

import static skills.knight.KnightConstants.SLAM_DMG_LVL_UP;
import static skills.knight.KnightConstants.SLAM_INITIAL_DMG;
import static skills.knight.KnightConstants.SLAM_VS_KNIGHT;
import static skills.knight.KnightConstants.SLAM_VS_PYROMANCER;
import static skills.knight.KnightConstants.SLAM_VS_WIZARD;
import static skills.knight.KnightConstants.SLAM_VS_ROGUE;
import static skills.knight.KnightConstants.KNIGHT_LAND_BONUS;
import static skills.knight.KnightConstants.SLAM_STUN_DURATION;

public final class Slam extends Skill {

    public Slam(final Hero caster, final Terrain terrain) {
        super(caster, terrain, SLAM_INITIAL_DMG);
    }

    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + SLAM_VS_PYROMANCER;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        pyromancer.setCurrentHp(pyromancer.getCurrentHp() - Math.round(Math.round((this.damage
                + SLAM_DMG_LVL_UP * caster.getLevel()) * terrainModifier) * totalDamageModifier));

        pyromancer.setStun(new Stun(SLAM_STUN_DURATION));
        pyromancer.setDamageOverTime(new DamageOverTime(0, 0));
    }

    @Override
    public void applyEffect(final Knight knight) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1f + SLAM_VS_KNIGHT;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        knight.setCurrentHp(knight.getCurrentHp() - Math.round(Math.round((this.damage
                + SLAM_DMG_LVL_UP * caster.getLevel()) * terrainModifier) * totalDamageModifier));

        knight.setStun(new Stun(SLAM_STUN_DURATION));
        knight.setDamageOverTime(new DamageOverTime(0, 0));
    }

    @Override
    public void applyEffect(final Rogue rogue) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + SLAM_VS_ROGUE;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        rogue.setCurrentHp(rogue.getCurrentHp() - Math.round(Math.round((this.damage
                + SLAM_DMG_LVL_UP * caster.getLevel()) * terrainModifier) * totalDamageModifier));

        rogue.setStun(new Stun(SLAM_STUN_DURATION));
        rogue.setDamageOverTime(new DamageOverTime(0, 0));
    }

    @Override
    public void applyEffect(final Wizard wizard) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + SLAM_VS_WIZARD;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        wizard.setCurrentHp(wizard.getCurrentHp() - Math.round(Math.round((this.damage
                + SLAM_DMG_LVL_UP * caster.getLevel()) * terrainModifier) * totalDamageModifier));

        wizard.setStun(new Stun(SLAM_STUN_DURATION));
        wizard.setDamageOverTime(new DamageOverTime(0, 0));
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
