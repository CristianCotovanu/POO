package com.exceptions.ex4;

import java.util.EnumSet;

public abstract class LoggerBase {
    LoggerBase nextLogger;
    EnumSet<LogLevel> logLevels;

    LoggerBase(EnumSet<LogLevel> logLevels) {
        this.logLevels = logLevels;
    }

    public void setNextLogger(LoggerBase nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void message(String message, LogLevel logLevel) {
        if (logLevels.contains(logLevel)) {
            writeMessage(message);
        }
        if (nextLogger != null) {
            nextLogger.message(message, logLevel);
        }
    }

    abstract protected void writeMessage(String message);
}
