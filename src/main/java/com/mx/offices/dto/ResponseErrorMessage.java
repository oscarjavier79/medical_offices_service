package com.mx.offices.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mx.offices.utils.MapperUtil;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({"messageType", "transactionID", "httpStatus", "timestamp", "errorCode", "message", "event", "details", "subErrors"})
public class ResponseErrorMessage extends ResponseMessage {
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String details;
    private String event;
    private List<ResponseErrorMessage> subErrors;

    public ResponseErrorMessage(@NonNull String transactionID, @NonNull HttpStatus httpStatus, @NonNull String errorCode, String message, String details, String event) {
        super(MessageTypeEnum.ERROR_MESSAGE, transactionID, (HttpStatus) Objects.requireNonNull(httpStatus), message);
        this.errorCode = (String)Objects.requireNonNull(errorCode);
        this.event = event;
        this.details = details;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getDetails() {
        return this.details;
    }

    public String getevent() {
        return this.event;
    }

    public List<ResponseErrorMessage> getSubErrors() {
        return this.subErrors;
    }

    public String toString() {
        return MapperUtil.jsonStringFromObject(this);
    }

    public static class ResponseErrorMessageBuilder {
        private ResponseErrorMessage responseErrorMessage;
        private String errorCode = "";
        private String details = "";
        private String event = "";
        private String message = "";
        private List<ResponseErrorMessage> subErrors;
        private HttpStatus httpStatus;
        private String transactionID;

        public ResponseErrorMessageBuilder() {
            this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            this.transactionID = "";
            this.subErrors = new ArrayList();
            this.responseErrorMessage = new ResponseErrorMessage(this.transactionID, this.httpStatus, this.errorCode, this.message, this.details, this.event);
        }

        public ResponseErrorMessageBuilder withTransactionID(String transactionID) {
            this.transactionID = transactionID;
            return this;
        }

        public ResponseErrorMessageBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public ResponseErrorMessageBuilder withErrorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public ResponseErrorMessageBuilder withDetails(String details) {
            this.details = details;
            return this;
        }

        public ResponseErrorMessageBuilder withEvent(String event) {
            this.event = event;
            return this;
        }

        public ResponseErrorMessageBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ResponseErrorMessageBuilder withSubError(List<ResponseErrorMessage> subErrors) {
            this.subErrors = subErrors;
            return this;
        }

        public ResponseErrorMessage build() {
            this.responseErrorMessage.errorCode = this.errorCode;
            this.responseErrorMessage.details = this.details;
            this.responseErrorMessage.subErrors = this.subErrors;
            this.responseErrorMessage.event = this.event;
            this.responseErrorMessage.setMessage(this.message);
            this.responseErrorMessage.setHttpStatus(this.httpStatus);
            this.responseErrorMessage.setTransactionID(this.transactionID);
            return this.responseErrorMessage;
        }
    }
}