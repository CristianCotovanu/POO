package skills;

import characters.heroes.Hero;
import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import map.Terrain;
import skills.knight.Execute;
import skills.knight.Slam;
import skills.pyromancer.Fireblast;
import skills.pyromancer.Ignite;
import skills.rogue.Backstab;
import skills.rogue.Paralysis;
import skills.wizard.Deflect;
import skills.wizard.Drain;

import java.util.List;

public final class SkillFactory {
    private static SkillFactory instance = null;

    private SkillFactory() { }

    public List<Skill> createSkill(final Hero caster, final Terrain terrain) {
        if (caster instanceof Pyromancer) {
            return List.of(new Fireblast(caster, terrain), new Ignite(caster, terrain));
        } else if (caster instanceof Knight) {
            return List.of(new Execute(caster, terrain), new Slam(caster, terrain));
        } else if (caster instanceof Rogue) {
            return List.of(new Backstab(caster, terrain), new Paralysis(caster, terrain));
        } else if (caster instanceof Wizard) {
            return List.of(new Drain(caster, terrain), new Deflect(caster, terrain));
        } else {
            return null;
        }
    }

    public static SkillFactory getInstance() {
        if (instance == null) {
            instance = new SkillFactory();
        }
        return instance;
    }
}
