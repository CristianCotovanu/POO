public class Point {
    private float x;
    private float y;



    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void changeCoords(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void printPoint() {
        System.out.println('(' + this.x +','+ this.y +')');
    }
}
