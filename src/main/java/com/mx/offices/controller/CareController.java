package com.mx.offices.controller;


import com.mx.offices.dto.*;
import com.mx.offices.dto.examples.Response400;
import com.mx.offices.dto.examples.Response500;
import com.mx.offices.exceptions.ComponentException;
import com.mx.offices.service.CareService;
import com.mx.offices.service.MedicsService;
import com.mx.offices.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/care")
@Api(value = "Medics Service", tags = "Care administration")
@Slf4j
public class CareController {
      CareService careService;

      public CareController(CareService careService) {
            this.careService = careService;
      }

      @ApiOperation(
              nickname = "Microservice para obtener informacion de las citas activas",
              value = "Obtener informacion de las citas activas",
              notes = "Informacion de citas activas."
      )
      @ApiResponses(value = {
              @ApiResponse(code = 400, message = "Bad request.", response = Response400.class),
              @ApiResponse(code = 500, message = "Internal Server Error.",  response = Response500.class)
               })
      @GetMapping(path = "/getCares")
      public ResponseEntity<Object> getCares() throws Exception {
            log.info("obteniendo informacion de citas");
            List<CareDto> medicDtoList = careService.getAllCares();
            ResponseMessage responseServiceMessage = new ResponseServiceMessage.ResponseServiceMessageBuilder()
                    .withMessage("success")
                    .withData(medicDtoList)
                    .withHttpStatus(HttpStatus.OK)
                    .build();
            return new ResponseEntity<>(responseServiceMessage, HttpStatus.OK);
      }

      @ApiOperation(
              nickname = "Microservice para el registro de citas",
              value = "Registrar citas en el sistema",
              notes = "Registrar citas."
      )
      @ApiResponses(value = {
              @ApiResponse(code = 400, message = "Bad request.", response = Response400.class),
              @ApiResponse(code = 500, message = "Internal Server Error.",  response = Response500.class)
      })
      @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<Object> createCares(@RequestBody @Valid String request) throws Exception {
            log.info("guardando informacion de citas");
            RequestServiceMessage requestServiceMessage = MapperUtil.gson.fromJson(request, RequestServiceMessage.class);
            careService.createCare(requestServiceMessage);
            ResponseMessage responseServiceMessage = new ResponseServiceMessage.ResponseServiceMessageBuilder()
                    .withMessage("success")
                    .withHttpStatus(HttpStatus.CREATED)
                    .build();
            return new ResponseEntity<>(responseServiceMessage, HttpStatus.CREATED);
      }

      @ApiOperation(
              nickname = "Microservice para modificar datos de citas",
              value = "Modificar informacion de citas registrados en sistema",
              notes = "Modificacion de datos del citas."
      )
      @ApiResponses(value = {
              @ApiResponse(code = 400, message = "Bad request.", response = Response400.class),
              @ApiResponse(code = 500, message = "Internal Server Error.",  response = Response500.class)
      })
      @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<Object> updateCare(@RequestBody @Valid String request) throws Exception {
            log.info("actualizando informacion de citas");
            RequestServiceMessage requestServiceMessage = MapperUtil.gson.fromJson(request, RequestServiceMessage.class);
            careService.updateCare(requestServiceMessage);

            ResponseMessage responseServiceMessage = new ResponseServiceMessage.ResponseServiceMessageBuilder()
                    .withMessage("success")
                    .withHttpStatus(HttpStatus.OK)
                    .build();

            return new ResponseEntity<>(responseServiceMessage, HttpStatus.OK);
      }

}
