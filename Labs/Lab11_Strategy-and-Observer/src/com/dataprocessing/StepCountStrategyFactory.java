package com.dataprocessing;

import com.main.Utils;
import com.storage.DataRepository;

public class StepCountStrategyFactory {
    private static StepCountStrategyFactory instance = null;

    public StepCountStrategy createStrategy(DataRepository dataRepository, String strategyDescription) {
        if (strategyDescription.equals(Utils.BASIC_STRATEGY)) {
            return new BasicStepCountStrategy(dataRepository, strategyDescription);
        } else if (strategyDescription.equals(Utils.FILTERED_STRATEGY)) {
            return new FilteredStepCountStrategy(dataRepository, strategyDescription);
        } else {
            return null;
        }
    }

    public static StepCountStrategyFactory getInstance() {
        if (instance == null) {
            return new StepCountStrategyFactory();
        }

        return instance;
    }

}
