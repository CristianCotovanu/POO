package com.task1.note4;

interface Engine {
    public int getFuelCapacity();
}

class Car {
    public Engine getEngine() {
        class OttoEngine implements Engine {
            private int fuelCapacity = 11;

            public int getFuelCapacity() {
                return fuelCapacity;
            }
        }

        return new OttoEngine();
    }
}

public class Test {
    public static void main(String[] args) {
        Car car = new Car();

        Engine firstEngine = car.getEngine();
        Engine secondEngine = car.getEngine();

        System.out.println(firstEngine.getFuelCapacity());
        System.out.println(secondEngine.getFuelCapacity());
    }
}

