package com.mx.offices.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mx.offices.utils.MapperUtil;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@JsonPropertyOrder({"transactionID", "messageType", "timestamp", "logLevel", "data"})
public class LogTransactionMessage<T extends Serializable> extends LogMessage {
    private static final long serialVersionUID = 1L;
    private T data;

    public LogTransactionMessage(@NonNull RequestServiceMessage requestServiceMessage) {
        super(requestServiceMessage.getTransactionID(), MessageTypeEnum.LOGTRANSACTION_MESSAGE, LogLevelEnum.INFO);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return MapperUtil.jsonStringFromObject(this);
    }
}