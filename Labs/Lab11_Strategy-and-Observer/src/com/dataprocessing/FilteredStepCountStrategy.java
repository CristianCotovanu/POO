package com.dataprocessing;

import com.storage.DataRepository;
import com.storage.SensorData;

import java.util.concurrent.TimeUnit;

public class FilteredStepCountStrategy extends AbstractStepCountStrategy {
    private static final int MAX_DIFF_STEPS_CONSECUTIVE_RECORDS = 1000;
    private static final long TIME_FOR_MAX_DIFF = TimeUnit.SECONDS.toMillis(1);

    protected FilteredStepCountStrategy(DataRepository dataRepository, String strategyDescription) {
        super(dataRepository, strategyDescription);
    }

    @Override
    public int getTotalSteps() {
        int sum = 0;
        int ind = -1;
        for (SensorData d : dataRepository.getStoredData()) {
            if (ind != -1)
                if (d.getStepsCount() < 0 ||
                        ((d.getStepsCount() - dataRepository.getStoredData().get(ind).getStepsCount()) > 1000
                                && (d.getTimestamp() - dataRepository.getStoredData().get(ind).getTimestamp()) <
                                TIME_FOR_MAX_DIFF)) {
                    ind++;
                    continue;
                }
            sum += d.getStepsCount();
            ind++;
        }
        return sum;
    }
}