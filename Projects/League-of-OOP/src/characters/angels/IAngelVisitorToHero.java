package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;

public interface IAngelVisitorToHero {
    void visitHero(Pyromancer pyromancer);

    void visitHero(Knight knight);

    void visitHero(Rogue rogue);

    void visitHero(Wizard wizard);
}
