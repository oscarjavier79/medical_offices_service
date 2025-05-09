package com.mx.offices.dto;

import org.apache.logging.log4j.Level;

public enum LogLevelEnum {
    OFF(Level.OFF, "No events will be logged."),
    ALL(Level.ALL, "All events should be logged."),
    DEBUG(Level.DEBUG, "A general debugging event."),
    ERROR(Level.ERROR, "An error in the application, possibly recoverable"),
    FATAL(Level.FATAL, "A severe error that will prevent the application from continuing."),
    INFO(Level.INFO, "An event for informational purposes."),
    TRACE(Level.TRACE, "A fine-grained debug message, typically capturing the flow through the application"),
    WARNING(Level.WARN, "An event that might possible lead to an error.");

    private final Level level;
    private final String description;

    private LogLevelEnum(Level level, String description) {
        this.level = level;
        this.description = description;
    }

    public Level getLevel() {
        return this.level;
    }

    public String getDescription() {
        return this.description;
    }
}
