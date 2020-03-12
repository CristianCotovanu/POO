package com.dataprocessing;

import com.storage.DataRepository;

public abstract class AbstractStepCountStrategy implements StepCountStrategy {
    private String strategyDescription;
    DataRepository dataRepository;

    AbstractStepCountStrategy(DataRepository dataRepository, String strategyDescription) {
        this.dataRepository = dataRepository;
        this.strategyDescription = strategyDescription;
    }

    public abstract int getTotalSteps();

    @Override
    public String getStrategyDescription() {
        return strategyDescription;
    }
}
