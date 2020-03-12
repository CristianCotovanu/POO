package Candies;

public class Baravelli extends CandyBox {
    float radius;
    float height;

    public Baravelli () {}

    public Baravelli (float height, float radius, String flavor, String origin) {
        super(origin, flavor);
        this.height = height;
        this.radius = radius;
    }

    public float getVolume () {
        return radius * height;
    }

    void printBaravelliDim () {
        System.out.println("Candies.Baravelli: ");
        System.out.println("Radius is: " + radius + '\n' +
                            "Height is: " + height + ". ");
    }

    public void print() {
        System.out.println("Candies.Baravelli: ");
        System.out.println("Radius is: " + radius + '\n' +
                "Height is: " + height + ". ");
    }
}
