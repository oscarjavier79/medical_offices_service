package com.mx.offices.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpHeaders;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDetails implements Serializable {
	private HttpHeaders httpHeaders;
    private Serializable response;
}
