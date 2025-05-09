package com.mx.offices.dto;

import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class RequestMessage<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;
    private final MessageTypeEnum messageType;
    private String transactionID;
    private String componentID;
    private final String timestamp;
    private HttpHeaders httpHeaders;
    private String endpoint;
    private T data;

    protected RequestMessage(@NonNull MessageTypeEnum messageType, @NonNull String transactionID, @NonNull String componentID, HttpHeaders httpHeaders, String endpoint, T data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SS");
        this.messageType = (MessageTypeEnum) Objects.requireNonNull(messageType);
        this.transactionID = (String)Objects.requireNonNull(transactionID);
        this.componentID = (String)Objects.requireNonNull(componentID);
        this.timestamp = LocalDateTime.now().format(formatter);
        this.httpHeaders = httpHeaders;
        this.endpoint = endpoint;
        this.data = data;
    }

    public MessageTypeEnum getMessageType() {
        return this.messageType;
    }

    public String getTransactionID() {
        return this.transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getComponentID() {
        return this.componentID;
    }

    public void setComponentID(String componentID) {
        this.componentID = componentID;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public HttpHeaders getHttpHeaders() {
        return this.httpHeaders;
    }

    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
