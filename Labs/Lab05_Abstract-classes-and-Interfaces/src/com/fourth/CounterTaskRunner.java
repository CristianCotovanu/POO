package com.fourth;

import com.first.CounterOutTask;
import com.first.Task;
import com.third.Strategy;

public class CounterTaskRunner extends AbstractTaskRunner {
    private int counter;

    public CounterTaskRunner(Strategy strategy) {
        super(strategy);
    }

    public int getCounter() {
//        CounterOutTask counter = new CounterOutTask();
//        counter.execute();
        return ++counter;
    }

    @Override
    protected void afterExecution(Task task) {

    }
}
