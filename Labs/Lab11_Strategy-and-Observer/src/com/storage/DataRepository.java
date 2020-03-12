package com.storage;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Persists sensor data. Observable, its observers are notified when data is added it to.
 */
public class DataRepository extends Observable {
    private List<SensorData> sensorDataList;

    public DataRepository() {
        sensorDataList = new ArrayList<>();
    }

    public void addData(SensorData dataRecord){
        sensorDataList.add(dataRecord);
        setChanged();
        notifyObservers(dataRecord);
    }

    public List<SensorData> getStoredData() {
        return sensorDataList;
    }

    public void setSensorDataList(List<SensorData> sensorDataList) {
        this.sensorDataList = sensorDataList;
    }
}


