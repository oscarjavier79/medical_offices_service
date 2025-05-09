package com.mx.offices.exceptions;

import com.mx.offices.utils.MapperUtil;
import lombok.Data;

import java.io.Serializable;

@Data
public class ErrorMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String message;
    private String level;
    private String event;
    private Integer httpStatus;

    public ErrorMessage() {
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getLevel() {
        return this.level;
    }

    public String getEvent() {
        return this.event;
    }

    public Integer getHttpStatus() {
        return this.httpStatus;
    }

    public String toString() {
        return MapperUtil.jsonStringFromObject(this);
    }

    public static class ErrorMessageBuilder {
        ErrorMessage errorMessage = new ErrorMessage();
        private String code = "";
        private String message = "";
        private String level = "";
        private String event = "";
        private Integer httpStatus = 0;

        public ErrorMessageBuilder() {
            this.errorMessage = new ErrorMessage();
        }

        public ErrorMessageBuilder withCode(String code) {
            this.code = code;
            return this;
        }

        public ErrorMessageBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ErrorMessageBuilder withLevel(String level) {
            this.level = level;
            return this;
        }

        public ErrorMessageBuilder withEvent(String event) {
            this.event = event;
            return this;
        }

        public ErrorMessageBuilder withHttpStatus(Integer httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public ErrorMessage build() {
            this.errorMessage.code = this.code;
            this.errorMessage.message = this.message;
            this.errorMessage.level = this.level;
            this.errorMessage.event = this.event;
            this.errorMessage.httpStatus = this.httpStatus;
            return this.errorMessage;
        }
    }
}
