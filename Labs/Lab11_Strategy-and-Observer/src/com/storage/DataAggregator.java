package com.storage;

import com.dataprocessing.StepCountStrategy;

import java.util.Observable;
import java.util.Observer;

public class DataAggregator implements Observer {
    private StepCountStrategy stepCountStrategy;

    public DataAggregator(StepCountStrategy stepCountStrategy) {
        this.stepCountStrategy = stepCountStrategy;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Total steps: " + stepCountStrategy.getTotalSteps());
    }
}
