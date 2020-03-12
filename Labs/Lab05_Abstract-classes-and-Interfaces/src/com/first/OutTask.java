package com.first;

public class OutTask implements Task {
    String message;

    public OutTask(String s) {
        this.message = s;
    }

    @Override
    public void execute() {
        System.out.println(message);
    }
}
