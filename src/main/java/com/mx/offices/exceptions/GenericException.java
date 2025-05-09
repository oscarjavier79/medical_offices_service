package com.mx.offices.exceptions;

import com.mx.offices.dto.RequestServiceMessage;

public abstract class GenericException extends Exception {
    private static final long serialVersionUID = 1L;
    private final ErrorMessage errorMessage;
    private final RequestServiceMessage requestServiceMessage;
    private final String details;

    protected GenericException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorMessage errorMessage, RequestServiceMessage requestServiceMessage, String details) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorMessage = errorMessage;
        this.requestServiceMessage = requestServiceMessage;
        this.details = details;
    }

    public String getDetails() {
        return this.details;
    }

    public ErrorMessage getErrorMessage() {
        return this.errorMessage;
    }

    public RequestServiceMessage getRequestServiceMessage() {
        return this.requestServiceMessage;
    }
}
