package map;

import skills.ITerrainVisitor;

public final class Land extends Terrain {
    Land() {
        super();
    }

    @Override
    public float acceptSkill(final ITerrainVisitor skill) {
        return skill.visitTerrain(this);
    }
}
