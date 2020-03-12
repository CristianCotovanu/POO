package com.first;

public class CounterOutTask implements Task {
    static int counter;

    public CounterOutTask() {}

    @Override
    public void execute() {
        counter++;
        System.out.println("Counter is: " + this.counter);
    }
}
