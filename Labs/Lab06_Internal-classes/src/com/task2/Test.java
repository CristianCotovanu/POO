package com.task2;

interface Engine {
    public int getFuelCapacity();
}


class Car {
    String type;

    Engine getTesla() {
        return new Engine() {
            @Override
            public int getFuelCapacity() {
                return 99;
            }
        };
    }

    static class Ferrari {
        public Ferrari getEngine(String type) {
            return new Ferrari();
        }
    }

    private class OttoEngine implements Engine {
        private int fuelCapacity;

        OttoEngine(int fuelCapacity) {
            this.fuelCapacity = fuelCapacity;
        }

        public int getFuelCapacity() {
            return fuelCapacity;
        }
    }

    OttoEngine getEngine() {
        return new OttoEngine(11);
    }
}

public class Test {
    public static void main(String[] args) {
        Car car = new Car();

        Engine firstEngine = car.getEngine();
        Car.Ferrari ferrari =  new Car.Ferrari();
        Engine tesla = car.getTesla();

        System.out.println(firstEngine.getFuelCapacity());
        System.out.println(tesla.getFuelCapacity());
    }
}

