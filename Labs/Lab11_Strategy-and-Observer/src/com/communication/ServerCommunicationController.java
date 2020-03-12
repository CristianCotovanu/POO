package com.communication;

import com.main.Utils;
import com.storage.SensorData;

import java.util.Observable;
import java.util.Observer;

public class ServerCommunicationController implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        SensorData data = (SensorData) arg;
        forwardMessage(((SensorData) arg).getStepsCount(), ((SensorData) arg).getTimestamp());
    }

    private void forwardMessage(int stepsCount, long timestamp) {
        ServerMessage serverMessage = new ServerMessage(stepsCount, Utils.getClientId(), timestamp);
        printMessage(serverMessage);
    }

    private void printMessage(ServerMessage serverMessage) {
        System.out.println("[Server] " + serverMessage);
    }
}
