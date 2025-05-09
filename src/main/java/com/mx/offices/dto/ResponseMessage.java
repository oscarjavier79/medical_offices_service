package com.mx.offices.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public abstract class ResponseMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    private final MessageTypeEnum messageType;
    private String transactionID;
    private HttpStatus httpStatus;
    private final String timestamp;
    private String message;

    protected ResponseMessage(MessageTypeEnum messageType, String transactionID, HttpStatus httpStatus) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SS");
        this.messageType = messageType;
        this.httpStatus = httpStatus;
        this.timestamp = LocalDateTime.now().format(formatter);
    }

    protected ResponseMessage(MessageTypeEnum messageType, String transactionID, HttpStatus httpStatus, String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SS");
        this.messageType = messageType;
        this.transactionID = transactionID;
        this.httpStatus = httpStatus;
        this.timestamp = LocalDateTime.now().format(formatter);
        this.message = message;
    }

    public String getTransactionID() {
        return this.transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageTypeEnum getMessageType() {
        return this.messageType;
    }

}
