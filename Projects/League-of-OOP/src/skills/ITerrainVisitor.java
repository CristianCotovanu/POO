package skills;

import map.Desert;
import map.Land;
import map.Volcanic;
import map.Woods;

public interface ITerrainVisitor {
    float visitTerrain(Volcanic volcanic);

    float visitTerrain(Land land);

    float visitTerrain(Woods woods);

    float visitTerrain(Desert desert);
}
