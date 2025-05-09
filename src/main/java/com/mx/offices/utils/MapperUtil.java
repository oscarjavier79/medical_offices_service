package com.mx.offices.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mx.offices.dto.ResponseDetails;
import com.mx.offices.dto.ResponseMessage;
import com.mx.offices.dto.ResponseServiceMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

public class MapperUtil {
    private static final Logger logger = LogManager.getLogger(MapperUtil.class);
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final Gson gson = new Gson();

    private MapperUtil() {
        throw new IllegalStateException("MapperUtil class");
    }

    public static String jsonStringFromObject(Object objeto) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;

        try {
            jsonString = mapper.writeValueAsString(objeto);
        } catch (JsonProcessingException var4) {
            logger.error(var4);
        }

        return jsonString;
    }

    public ResponseMessage buildResponseServiceMessage(ResponseDetails responseDetails, String message, HttpStatus httpStatus) {
        ResponseMessage sessionCartDtoResponseServiceMessage;
        sessionCartDtoResponseServiceMessage = new ResponseServiceMessage.ResponseServiceMessageBuilder()
                .withData(responseDetails)
                .withMessage(message)
                .withHttpStatus(httpStatus)
                .build();
        return sessionCartDtoResponseServiceMessage;
    }
}
