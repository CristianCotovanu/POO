import java.util.ArrayList;

public class Polygon {
    private int nrCorners;
    private Point[] points;

    public Polygon(int corners) {
        this.nrCorners = corners;
        this.points = new Point[corners];
    }

    public Polygon(float[] coords) {
        this(coords.length/2);
        int j = 0;
        for(int i = 0; i < coords.length; i++) {
            points[j] = new Point(coords[i], coords[i + 1]);
            j++;
        }
    }
}
