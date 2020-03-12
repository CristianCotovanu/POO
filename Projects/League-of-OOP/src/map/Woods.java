package map;

import skills.ITerrainVisitor;

public final class Woods extends Terrain {
    Woods() {
        super();
    }

    @Override
    public float acceptSkill(final ITerrainVisitor skill) {
        return skill.visitTerrain(this);
    }
}
