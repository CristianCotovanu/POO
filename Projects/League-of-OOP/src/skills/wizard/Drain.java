package skills.wizard;

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

import static skills.wizard.WizardConstants.WIZARD_DRAIN_FORMULA_OPERAND;

public final class Drain extends Skill {
    public Drain(final Hero caster, final Terrain terrain) {
        super(caster, terrain, 0);
    }

    @Override
    public void applyEffect(final Pyromancer pyromancer) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + WizardConstants.DRAIN_VS_PYROMANCER;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        float heroHp = Math.min(WIZARD_DRAIN_FORMULA_OPERAND
                * pyromancer.getMaxHp(), pyromancer.getCurrentHp());
        float percentage = (WizardConstants.DRAIN_INITIAL_PERCENTAGE + caster.getLevel()
                        * WizardConstants.DRAIN_PERCENTAGE_LVL_UP)
                        * terrainModifier * totalDamageModifier;

        pyromancer.setCurrentHp(pyromancer.getCurrentHp() - Math.round(heroHp * percentage));
    }

    @Override
    public void applyEffect(final Knight knight) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + WizardConstants.DRAIN_VS_KNIGHT;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        float heroHp = Math.min(WIZARD_DRAIN_FORMULA_OPERAND
                * knight.getMaxHp(), knight.getCurrentHp());
        float percentage = (WizardConstants.DRAIN_INITIAL_PERCENTAGE + caster.getLevel()
                * WizardConstants.DRAIN_PERCENTAGE_LVL_UP)
                * terrainModifier * totalDamageModifier;

        knight.setCurrentHp(knight.getCurrentHp() - Math.round(heroHp * percentage));
    }

    @Override
    public void applyEffect(final Rogue rogue) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + WizardConstants.DRAIN_VS_ROGUE;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        float heroHp = Math.min(WIZARD_DRAIN_FORMULA_OPERAND
                * rogue.getMaxHp(), rogue.getCurrentHp());
        float percentage = (WizardConstants.DRAIN_INITIAL_PERCENTAGE + caster.getLevel()
                * WizardConstants.DRAIN_PERCENTAGE_LVL_UP)
                * terrainModifier * totalDamageModifier;

        rogue.setCurrentHp(rogue.getCurrentHp() - Math.round(heroHp * percentage));
    }

    @Override
    public void applyEffect(final Wizard wizard) {
        float terrainModifier = getTerrainModifier();
        float raceModifier = 1 + WizardConstants.DRAIN_VS_WIZARD;

        float totalDamageModifier = caster.computeDamageModifier(raceModifier);

        float heroHp = Math.min(WIZARD_DRAIN_FORMULA_OPERAND
                * wizard.getMaxHp(), wizard.getCurrentHp());
        float percentage = (WizardConstants.DRAIN_INITIAL_PERCENTAGE + caster.getLevel()
                * WizardConstants.DRAIN_PERCENTAGE_LVL_UP)
                * terrainModifier * totalDamageModifier;

        wizard.setCurrentHp(wizard.getCurrentHp() - Math.round(heroHp * percentage));
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
        return 0;
    }

    @Override
    public float visitTerrain(final Desert desert) {
        return WizardConstants.WIZARD_DESERT_BONUS;
    }
}
