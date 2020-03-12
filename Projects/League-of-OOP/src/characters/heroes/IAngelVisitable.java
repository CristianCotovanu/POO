package characters.heroes;

import characters.angels.IAngelVisitorToHero;

public interface IAngelVisitable {
    void acceptAngel(IAngelVisitorToHero angel);
}
