package com.first;

public class RandomOutTask implements Task {

    int random;

    public RandomOutTask() {
        this.random = (int) (Math.random() * 100);
    }

    @Override
    public void execute() {
        System.out.print("Random number is: " + random);
        System.out.println();
    }
}
