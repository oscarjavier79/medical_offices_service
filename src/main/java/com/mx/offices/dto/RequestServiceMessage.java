package com.mx.offices.dto;

import com.mx.offices.utils.MapperUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;

import java.io.Serializable;

public class RequestServiceMessage extends RequestMessage {
    private static final long serialVersionUID = 1L;

    public RequestServiceMessage(@NonNull String transactionID, @NonNull String componentID, HttpHeaders httpHeaders, String endpoint, Object data) {
        super(MessageTypeEnum.REQUEST_MESSAGE, transactionID, componentID, httpHeaders, endpoint, (Serializable)data);
    }

    public String toString() {
        return MapperUtil.jsonStringFromObject(this);
    }

    public static class RequestServiceMessageBuilder {
        private RequestServiceMessage requestServiceMessage;
        private String transactionId = "";
        private String componentId = "";
        private HttpHeaders httpHeaders = new HttpHeaders();
        private String endpoint = "";
        private Object data = "";

        public RequestServiceMessageBuilder() {
            this.requestServiceMessage = new RequestServiceMessage(this.transactionId, this.componentId, this.httpHeaders, this.endpoint, this.data);
        }

        public RequestServiceMessageBuilder withTransactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public RequestServiceMessageBuilder withComponentId(String componentId) {
            this.componentId = componentId;
            return this;
        }

        public RequestServiceMessageBuilder withHttpHeaders(HttpHeaders httpHeaders) {
            this.httpHeaders = httpHeaders;
            return this;
        }

        public RequestServiceMessageBuilder withEndpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        public RequestServiceMessageBuilder withData(Object data) {
            this.data = data;
            return this;
        }

        public RequestServiceMessage build() {
            this.requestServiceMessage.setTransactionID(this.transactionId);
            this.requestServiceMessage.setComponentID(this.componentId);
            this.requestServiceMessage.setHttpHeaders(this.httpHeaders);
            this.requestServiceMessage.setEndpoint(this.endpoint);
            this.requestServiceMessage.setData((Serializable)this.data);
            return this.requestServiceMessage;
        }
    }
}
