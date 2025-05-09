package com.mx.offices.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@JsonPropertyOrder({"messageType", "transactionID", "httpStatus", "timestamp", "message", "data"})
public class ResponseServiceMessage<T extends Serializable> extends ResponseMessage {
    private static final long serialVersionUID = 1L;
    private T data;

    public ResponseServiceMessage(@NonNull String transactionID, T data) {
        super(MessageTypeEnum.RESPONSE_MESSAGE, transactionID, HttpStatus.OK);
        this.data = data;
    }

    public T getdata() {
        return this.data;
    }

    public static class ResponseServiceMessageBuilder {
        private ResponseServiceMessage responseServiceMessage;
        private Object data = "";
        private String message = "";
        private HttpStatus httpStatus;
        private String transactionID;

        public ResponseServiceMessageBuilder() {
            this.httpStatus = HttpStatus.OK;
            this.transactionID = "";
            this.responseServiceMessage = new ResponseServiceMessage(this.transactionID, (Serializable)this.data);
        }

        public ResponseServiceMessageBuilder withTransactionID(String transactionID) {
            this.transactionID = transactionID;
            return this;
        }

        public ResponseServiceMessageBuilder withData(Object data) {
            this.data = data;
            return this;
        }

        public ResponseServiceMessageBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ResponseServiceMessageBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public ResponseServiceMessage build() {
            this.responseServiceMessage.data = (Serializable)this.data;
            this.responseServiceMessage.setMessage(this.message);
            this.responseServiceMessage.setHttpStatus(this.httpStatus);
            this.responseServiceMessage.setTransactionID(this.transactionID);
            return this.responseServiceMessage;
        }
    }
}
