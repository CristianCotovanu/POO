package com.dataprocessing;

import com.storage.DataRepository;
import com.storage.SensorData;

public class BasicStepCountStrategy extends AbstractStepCountStrategy {
    protected BasicStepCountStrategy(DataRepository dataRepository, String strategyDescription) {
        super(dataRepository, strategyDescription);
    }

    @Override
    public int getTotalSteps() {
        int sum = 0;
        for(SensorData data : dataRepository.getStoredData()) {
            sum += data.getStepsCount();

        }
        return sum;
    }
}
