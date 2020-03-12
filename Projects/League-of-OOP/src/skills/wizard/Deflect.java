package skills.wizard;

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
import skills.SkillFactory;

import java.util.List;

import static skills.knight.KnightConstants.SLAM_DMG_LVL_UP;
import static skills.knight.KnightConstants.SLAM_INITIAL_DMG;
import static skills.knight.KnightConstants.EXECUTE_INITIAL_DMG;
import static skills.knight.KnightConstants.EXECUTE_DMG_LVL_UP;
import static skills.pyromancer.PyromancerConstants.FIREBLAST_DMG_LVL_UP;
import static skills.pyromancer.PyromancerConstants.FIREBLAST_INITIAL_DMG;
import static skills.pyromancer.PyromancerConstants.IGNITE_BASE_DMG_LVL_UP;
import static skills.pyromancer.PyromancerConstants.IGNITE_INITIAL_BASE_DMG;
import static skills.rogue.RogueConstants.BACKSTAB_DMG_LVL_UP;
import static skills.rogue.RogueConstants.BACKSTAB_INITIAL_DMG;
import static skills.rogue.RogueConstants.LUCKY_CRIT_ROUND;
import static skills.rogue.RogueConstants.PARALYSIS_INITIAL_DMG;
import static skills.rogue.RogueConstants.ROGUE_CRIT_BONUS;
import static skills.rogue.RogueConstants.PARALYSIS_DMG_LVL_UP;
import static skills.wizard.WizardConstants.DEFLECT_INITIAL_PERCENTAGE;
import static skills.wizard.WizardConstants.DEFLECT_MAX_PERCENTAGE;
import static skills.wizard.WizardConstants.DEFLECT_PERCENTAGE_LVL_UP;
import static skills.wizard.WizardConstants.DEFLECT_VS_KNIGHT;
import static skills.wizard.WizardConstants.DEFLECT_VS_PYROMANCER;
import static skills.wizard.WizardConstants.DEFLECT_VS_ROGUE;
import static skills.wizard.WizardConstants.WIZARD_DESERT_BONUS;


public final class Deflect extends Skill {
    public Deflect(final Hero caster, final Terrain terrain) {
        super(caster, terrain, 0);
    }

    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + DEFLECT_VS_PYROMANCER;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        float percentageDeflected = DEFLECT_INITIAL_PERCENTAGE + caster.getLevel()
                * DEFLECT_PERCENTAGE_LVL_UP;

        if (percentageDeflected > DEFLECT_MAX_PERCENTAGE) {
            percentageDeflected = DEFLECT_MAX_PERCENTAGE;
        }

        SkillFactory skillFactory = SkillFactory.getInstance();

        List<Skill> enemySkills = skillFactory.createSkill(pyromancer, terrain);

        float terrainModifierEnemy = 1 + terrain.acceptSkill(enemySkills.get(0));
        float enemyFireblastDamage = Math.round((FIREBLAST_INITIAL_DMG
                        + FIREBLAST_DMG_LVL_UP * pyromancer.getLevel())
                        * terrainModifierEnemy);

        float enemyIgniteDamage = Math.round(((IGNITE_INITIAL_BASE_DMG
                        + IGNITE_BASE_DMG_LVL_UP * pyromancer.getLevel()))
                        * terrainModifierEnemy);

        float totalDmgDeflected = enemyFireblastDamage + enemyIgniteDamage;

        pyromancer.setCurrentHp(pyromancer.getCurrentHp() - Math.round(percentageDeflected
                * totalDmgDeflected * terrainModifier * totalDamageModifier));
    }

    @Override
    public void applyEffect(final Knight knight) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + DEFLECT_VS_KNIGHT;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        float percentageDeflected = DEFLECT_INITIAL_PERCENTAGE
                    + caster.getLevel() * DEFLECT_PERCENTAGE_LVL_UP;

        if (percentageDeflected > DEFLECT_MAX_PERCENTAGE) {
            percentageDeflected = DEFLECT_MAX_PERCENTAGE;
        }

        SkillFactory skillFactory = SkillFactory.getInstance();

        List<Skill> enemySkills = skillFactory.createSkill(knight, terrain);

        float terrainModifierEnemy = 1 + terrain.acceptSkill(enemySkills.get(0));

        float enemyExecuteDamage = Math.round((EXECUTE_INITIAL_DMG
                + EXECUTE_DMG_LVL_UP * knight.getLevel())
                * terrainModifierEnemy);

        float enemySlamDamage = Math.round(((SLAM_INITIAL_DMG
                + SLAM_DMG_LVL_UP * knight.getLevel()))
                * terrainModifierEnemy);

        float totalDmgDeflected = enemySlamDamage + enemyExecuteDamage;

        knight.setCurrentHp(knight.getCurrentHp() - Math.round(percentageDeflected
                * totalDmgDeflected * terrainModifier * totalDamageModifier));
    }

    @Override
    public void applyEffect(final Rogue rogue) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + DEFLECT_VS_ROGUE;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        float percentageDeflected = DEFLECT_INITIAL_PERCENTAGE + caster.getLevel()
                * DEFLECT_PERCENTAGE_LVL_UP;

        if (percentageDeflected > DEFLECT_MAX_PERCENTAGE) {
            percentageDeflected = DEFLECT_MAX_PERCENTAGE;
        }

        SkillFactory skillFactory = SkillFactory.getInstance();

        List<Skill> enemySkills = skillFactory.createSkill(rogue, terrain);

        float terrainModifierEnemy = 1 + terrain.acceptSkill(enemySkills.get(0));

        float enemyBackstabDamage;

        if (GameEngine.getRoundNumber() % LUCKY_CRIT_ROUND == 0 && terrainModifierEnemy != 1) {
            enemyBackstabDamage = Math.round((BACKSTAB_INITIAL_DMG
                    + BACKSTAB_DMG_LVL_UP * rogue.getLevel())
                    * terrainModifierEnemy * ROGUE_CRIT_BONUS);
        } else {
            enemyBackstabDamage = Math.round((BACKSTAB_INITIAL_DMG
                    + BACKSTAB_DMG_LVL_UP * rogue.getLevel())
                    * terrainModifierEnemy);
        }

        float enemyParalysisDamage = Math.round(((PARALYSIS_INITIAL_DMG
                + PARALYSIS_DMG_LVL_UP * rogue.getLevel()))
                * terrainModifierEnemy);

        float totalDmgDeflected = enemyBackstabDamage + enemyParalysisDamage;

        rogue.setCurrentHp(rogue.getCurrentHp() - Math.round(percentageDeflected
                * totalDmgDeflected * terrainModifier * totalDamageModifier));
    }

    @Override
    public void applyEffect(final Wizard wizard) { }

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
        return 0;
    }

    @Override
    public float visitTerrain(final Desert desert) {
        return WIZARD_DESERT_BONUS;
    }
}
