package com.mx.offices.dto;

import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class LogMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    private String transactionID;
    private final MessageTypeEnum messageType;
    private final String timestamp;
    private LogLevelEnum logLevel;

    protected LogMessage(@NonNull String transactionID, @NonNull MessageTypeEnum messageType, @NonNull LogLevelEnum logLevel) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SS");
        this.transactionID = (String) Objects.requireNonNull(transactionID);
        this.messageType = (MessageTypeEnum)Objects.requireNonNull(messageType);
        this.logLevel = (LogLevelEnum)Objects.requireNonNull(logLevel);
        this.timestamp = LocalDateTime.now().format(formatter);
    }

    public String getTransactionID() {
        return this.transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public MessageTypeEnum getMessageType() {
        return this.messageType;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public LogLevelEnum getLogLevel() {
        return this.logLevel;
    }

    public void setLogLevel(LogLevelEnum logLevel) {
        this.logLevel = logLevel;
    }
}
