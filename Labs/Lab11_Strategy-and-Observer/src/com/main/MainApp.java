package com.main;

import com.dataprocessing.StepCountStrategy;
import com.dataprocessing.StepCountStrategyFactory;
import com.storage.ConsoleLogger;
import com.storage.DataAggregator;
import com.storage.DataRepository;
import com.communication.ServerCommunicationController;
import com.storage.SensorData;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Choose a strategy: type 'basic or 'filtered");
        Scanner scanner = new Scanner(System.in);
        String strategyType = scanner.next();
        scanner.close();

        DataRepository dataRepository = new DataRepository();

        StepCountStrategyFactory stepCountStrategyFactory = StepCountStrategyFactory.getInstance();
        StepCountStrategy stepCountStrategy = stepCountStrategyFactory.createStrategy(dataRepository, strategyType);
        System.out.println("Strategy used will be: " + stepCountStrategy.getStrategyDescription() + "\n"
        );

//        Adding observers
        dataRepository.addObserver(new ConsoleLogger());
        dataRepository.addObserver(new ServerCommunicationController());
        dataRepository.addObserver(new DataAggregator(stepCountStrategy));

        long baseTimestamp = System.currentTimeMillis();

        dataRepository.addData(new SensorData(10, baseTimestamp + 1));
        System.out.println();

        dataRepository.addData(new SensorData(20, baseTimestamp + 2));
        System.out.println();

        dataRepository.addData(new SensorData(30, baseTimestamp + 3));
        System.out.println();

        // TODO: after the first successful run, change this to baseTimestamp + 40000 and check the result
        dataRepository.addData(new SensorData(4000, baseTimestamp + 4));
        System.out.println();

        dataRepository.addData(new SensorData(50, baseTimestamp + 5));
        System.out.println();

        dataRepository.addData(new SensorData(-100, baseTimestamp + 6));
        System.out.println();

        dataRepository.addData(new SensorData(500, baseTimestamp + 600));
        System.out.println();

    }
}
