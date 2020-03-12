package Candies;

import Candies.CandyBox;

public class ChocAmor extends CandyBox {
    float length;

    public ChocAmor() {
    }

    public ChocAmor(float length, String flavor, String origin) {
        super(origin, flavor);
        this.length = length;
    }

    public float getVolume () {
        return (float) Math.pow(length, 3);
    }

    void printChocAmorDim () {
        System.out.println("Candies.ChocAmor: ");
        System.out.println("Length is: " + length);
    }

    public void print() {
        System.out.println("Candies.ChocAmor: ");
        System.out.println("Length is: " + length);
    }

}
