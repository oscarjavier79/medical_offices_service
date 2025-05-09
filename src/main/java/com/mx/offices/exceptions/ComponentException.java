package com.mx.offices.exceptions;

import com.mx.offices.dto.RequestServiceMessage;

public class ComponentException extends GenericException {
    private static final long serialVersionUID = 1L;

    public ComponentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorMessage errorMessage, RequestServiceMessage requestServiceMessage, String details) {
        super(message, cause, enableSuppression, writableStackTrace, errorMessage, requestServiceMessage, details);
    }

    public static class ComponentExceptionBuilder {
        private String message = "";
        private Throwable cause = null;
        private boolean enableSuppression = true;
        private boolean writableStackTrace = true;
        private ErrorMessage errorMessage = null;
        private RequestServiceMessage requestServiceMessage = null;
        private String details = "";

        public ComponentExceptionBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ComponentExceptionBuilder withCause(Throwable cause) {
            this.cause = cause;
            return this;
        }

        public ComponentExceptionBuilder withEnableSuppression(boolean enableSuppression) {
            this.enableSuppression = enableSuppression;
            return this;
        }

        public ComponentExceptionBuilder withWritableStackTrace(boolean writableStackTrace) {
            this.writableStackTrace = writableStackTrace;
            return this;
        }

        public ComponentExceptionBuilder withDetails(String details) {
            this.details = details;
            return this;
        }

        public ComponentExceptionBuilder withErrorMessage(ErrorMessage errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public ComponentExceptionBuilder withRequestServiceMessage(RequestServiceMessage requestServiceMessage) {
            this.requestServiceMessage = requestServiceMessage;
            return this;
        }

        public ComponentExceptionBuilder() {
        }

        public ComponentException build() {
            return new ComponentException(this.message, this.cause, this.enableSuppression, this.writableStackTrace, this.errorMessage, this.requestServiceMessage, this.details);
        }
    }
}
