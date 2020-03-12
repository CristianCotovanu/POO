package com.storage;

import java.util.Observable;
import java.util.Observer;

public class ConsoleLogger implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        printChanges(arg);
    }

    private void printChanges(Object sensorData) {
        System.out.println("[Console] " + sensorData);
    }
}
