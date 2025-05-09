package com.mx.offices.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mx.offices.dto.LogEventMessage;
import com.mx.offices.dto.LogLevelEnum;
import com.mx.offices.dto.RequestServiceMessage;
import com.mx.offices.dto.ResponseErrorMessage;
import com.mx.offices.exceptions.ComponentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {ComponentException.class})
    public ResponseEntity deniedPermissionException(ComponentException cexp) throws JsonProcessingException {

        ResponseErrorMessage responseErrorMessage = (new ResponseErrorMessage.ResponseErrorMessageBuilder()).withErrorCode(cexp.getErrorMessage().getCode()).withMessage(cexp.getErrorMessage().getMessage()).withDetails(cexp.getDetails()).withEvent(cexp.getErrorMessage().getEvent()).withHttpStatus(HttpStatus.valueOf(cexp.getErrorMessage().getHttpStatus())).build();
        RequestServiceMessage requestServiceMessage = cexp.getRequestServiceMessage();
        StackTraceElement[] ste = cexp.getStackTrace();
        LogEventMessage<Serializable> eventMessage = new LogEventMessage(requestServiceMessage, LogLevelEnum.valueOf(cexp.getErrorMessage().getLevel()));
        eventMessage.setResponseErrorMessage(responseErrorMessage);
        return new ResponseEntity(responseErrorMessage, responseErrorMessage.getHttpStatus());
    }
}
