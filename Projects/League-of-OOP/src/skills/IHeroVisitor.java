package skills;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;


public interface IHeroVisitor {
    void applyEffect(Pyromancer pyromancer);

    void applyEffect(Knight knight);

    void applyEffect(Rogue rogue);

    void applyEffect(Wizard wizard);
}

