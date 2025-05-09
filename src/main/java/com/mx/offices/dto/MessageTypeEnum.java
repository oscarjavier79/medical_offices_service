package com.mx.offices.dto;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public enum MessageTypeEnum {
    REQUEST_MESSAGE(0, "Request Service Message", RequestMessage.class),
    RESPONSE_MESSAGE(1, "Response Service Message", ResponseServiceMessage.class),
    ERROR_MESSAGE(2, "Response Error Message", ResponseErrorMessage.class),
    LOGEVENT_MESSAGE(3, "Log Event Message", LogEventMessage.class),
    LOGTRANSACTION_MESSAGE(4, "Log Transactional Message", LogTransactionMessage.class);

    private final int code;
    private final String name;
    private Type classType;
    private static Map<Integer, MessageTypeEnum> typeByCode = new HashMap();
    private static Map<String, MessageTypeEnum> typeByName = new HashMap();

    private MessageTypeEnum(int code, String name, Type classType) {
        this.code = code;
        this.name = name;
        this.classType = classType;
    }

    public Type getClassType() {
        return this.classType;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public static MessageTypeEnum fromCode(int code) {
        return (MessageTypeEnum)typeByCode.get(code);
    }

    public static MessageTypeEnum fromName(String name) {
        return (MessageTypeEnum)typeByName.get(name != null ? name.toLowerCase() : null);
    }

    static {
        MessageTypeEnum[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            MessageTypeEnum type = var0[var2];
            typeByCode.put(type.code, type);
            typeByName.put(type.name.toLowerCase(), type);
        }

    }
}
