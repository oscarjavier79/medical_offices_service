package com.mx.offices.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mx.offices.utils.MapperUtil;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"transactionID", "messageType", "timestamp", "logLevel", "requestServiceMessage", "responseServiceMessage", "responseErrorMessage", "message"})
public class LogEventMessage<T extends Serializable> extends LogMessage {
    private static final long serialVersionUID = 1L;
    private RequestServiceMessage requestServiceMessage;
    private ResponseServiceMessage responseServiceMessage;
    private ResponseErrorMessage responseErrorMessage;
    private T message;

    public LogEventMessage(@NonNull RequestServiceMessage requestServiceMessage, ResponseServiceMessage responseServiceMessage, ResponseErrorMessage responseErrorMessage, LogLevelEnum logLevel) {
        super((String)Objects.requireNonNull(requestServiceMessage.getTransactionID()), (MessageTypeEnum)Objects.requireNonNull(MessageTypeEnum.LOGEVENT_MESSAGE), logLevel);
        this.requestServiceMessage = (RequestServiceMessage)Objects.requireNonNull(requestServiceMessage);
        this.responseServiceMessage = responseServiceMessage;
        this.responseErrorMessage = responseErrorMessage;
    }

    public LogEventMessage(@NonNull RequestServiceMessage requestServiceMessage, @NonNull LogLevelEnum logLevel) {
        super((String)Objects.requireNonNull(requestServiceMessage.getTransactionID()), (MessageTypeEnum)Objects.requireNonNull(MessageTypeEnum.LOGEVENT_MESSAGE), logLevel);
        this.requestServiceMessage = (RequestServiceMessage)Objects.requireNonNull(requestServiceMessage);
    }

    public LogEventMessage(@NonNull RequestServiceMessage requestServiceMessage, @NonNull ResponseServiceMessage responseServiceMessage, @NonNull LogLevelEnum logLevel) {
        super((String)Objects.requireNonNull(requestServiceMessage.getTransactionID()), (MessageTypeEnum)Objects.requireNonNull(MessageTypeEnum.LOGEVENT_MESSAGE), logLevel);
        this.requestServiceMessage = (RequestServiceMessage)Objects.requireNonNull(requestServiceMessage);
        this.responseServiceMessage = (ResponseServiceMessage)Objects.requireNonNull(responseServiceMessage);
    }

    public LogEventMessage(@NonNull RequestServiceMessage requestServiceMessage, @NonNull ResponseErrorMessage responseErrorMessage, @NonNull LogLevelEnum logLevel) {
        super((String)Objects.requireNonNull(requestServiceMessage.getTransactionID()), (MessageTypeEnum)Objects.requireNonNull(MessageTypeEnum.LOGEVENT_MESSAGE), logLevel);
        this.requestServiceMessage = (RequestServiceMessage)Objects.requireNonNull(requestServiceMessage);
        this.responseErrorMessage = (ResponseErrorMessage)Objects.requireNonNull(responseErrorMessage);
    }

    public LogEventMessage(@NonNull RequestServiceMessage requestServiceMessage, @NonNull T message, @NonNull LogLevelEnum logLevel) {
        super((String)Objects.requireNonNull(requestServiceMessage.getTransactionID()), (MessageTypeEnum)Objects.requireNonNull(MessageTypeEnum.LOGEVENT_MESSAGE), logLevel);
        this.requestServiceMessage = (RequestServiceMessage)Objects.requireNonNull(requestServiceMessage);
        this.message = (T) Objects.requireNonNull(message);
    }

    public RequestServiceMessage getRequestServiceMessage() {
        return this.requestServiceMessage;
    }

    public void setRequestServiceMessage(RequestServiceMessage requestServiceMessage) {
        this.requestServiceMessage = requestServiceMessage;
    }

    public ResponseServiceMessage getResponseServiceMessage() {
        return this.responseServiceMessage;
    }

    public void setResponseServiceMessage(ResponseServiceMessage responseServiceMessage) {
        this.responseServiceMessage = responseServiceMessage;
    }

    public ResponseErrorMessage getResponseErrorMessage() {
        return this.responseErrorMessage;
    }

    public void setResponseErrorMessage(ResponseErrorMessage responseErrorMessage) {
        this.responseErrorMessage = responseErrorMessage;
    }

    public T getMessage() {
        return this.message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public String toString() {
        return MapperUtil.jsonStringFromObject(this);
    }
}