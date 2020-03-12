package com.exceptions.ex4;

public class ConsoleLogger extends LoggerBase {
    public ConsoleLogger() {
        super(LogLevel.all());
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[Console] " + message);
    }
}
