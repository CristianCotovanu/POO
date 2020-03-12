package Candies;

import Candies.CandyBox;

public class Lindt extends CandyBox {
    float length;
    float width;
    float height;

    public Lindt() {
    }

    public Lindt(float length, float width, float height, String flavor, String origin) {
        super(origin, flavor);
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public float getVolume() {
        return width * height * length;
    }

    void printLindtDim () {
        System.out.println("Candies.Lindt: ");
        System.out.println("Length is: " + length + '\n' +
                "Height is: " + height + ". " + '\n' +
                "Width is: " + width);
    }

    public void print() {
        System.out.println("Candies.Lindt: ");
        System.out.println("Length is: " + length + '\n' +
                "Height is: " + height + ". " + '\n' +
                "Width is: " + width);
    }
}
