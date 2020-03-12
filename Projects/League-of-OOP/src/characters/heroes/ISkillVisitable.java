package characters.heroes;

import skills.IHeroVisitor;

public interface ISkillVisitable {
    void acceptSkill(IHeroVisitor skill);
}
