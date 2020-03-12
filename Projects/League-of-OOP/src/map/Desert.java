package map;

import skills.ITerrainVisitor;

public final class Desert extends Terrain {
    Desert() {
        super();
    }

    @Override
    public float acceptSkill(final ITerrainVisitor skill) {
        return skill.visitTerrain(this);
    }
}
