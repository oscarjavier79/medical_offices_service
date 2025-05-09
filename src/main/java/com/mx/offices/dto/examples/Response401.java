package com.mx.offices.dto.examples;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@ApiModel
@Setter
@Getter
public class Response401 {

      @ApiModelProperty(example = "5826871a-3ae5-4755-b173-459fa28c58de", name = "transactionID", dataType = "string", position = 2)
      private String transactionID;

      @ApiModelProperty(example = "UNAUTHORIZED", name = "httpStatus", dataType = "enum", position = 3)
      private HttpStatus httpStatus;

      @ApiModelProperty(example = "2021-04-07 16:21:36:03", name = "timestamp", dataType = "string", position = 4)
      private String timestamp;

      @ApiModelProperty(example = "UNAUTHORIZED", name = "errorCode", dataType = "string", position = 5)
      private String errorCode;

      @ApiModelProperty(example = "Unauthorized", name = "message", dataType = "string", position = 6)
      private String message;

      @ApiModelProperty(example = "ABORT", name = "event", dataType = "string", position = 7)
      private String event;

      @ApiModelProperty(example = "details", name = "details", dataType = "string", position = 8)
      private String details;

}
