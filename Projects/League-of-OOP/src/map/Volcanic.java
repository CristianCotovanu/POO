package map;

import skills.ITerrainVisitor;

public final class Volcanic extends Terrain {
    Volcanic() {
        super();
    }

    @Override
    public float acceptSkill(final ITerrainVisitor skill) {
        return skill.visitTerrain(this);
    }
}
