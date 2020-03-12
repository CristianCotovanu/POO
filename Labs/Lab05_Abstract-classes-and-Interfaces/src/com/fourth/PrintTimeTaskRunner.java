package com.fourth;

import com.first.Task;
import com.third.Strategy;

import java.util.Calendar;
import java.util.Date;

public class PrintTimeTaskRunner extends AbstractTaskRunner {
    public PrintTimeTaskRunner(Strategy strategy) {
        super(strategy);
    }

    @Override
    protected void afterExecution(Task task) {
        Date date = Calendar.getInstance().getTime();
        System.out.println("Time of execution is: " + date);
    }
}
