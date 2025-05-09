package com.mx.offices.controller;


import com.mx.offices.dto.MedicDto;
import com.mx.offices.dto.RequestServiceMessage;
import com.mx.offices.dto.ResponseMessage;
import com.mx.offices.dto.ResponseServiceMessage;
import com.mx.offices.dto.examples.Response400;
import com.mx.offices.dto.examples.Response500;
import com.mx.offices.exceptions.ComponentException;
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
@RequestMapping("api/medics")
@Api(value = "Medics Service", tags = "Servicio para dar de alta, obtener y modificar medicos")
@Slf4j
public class MedicsController {
      MedicsService medicsService;

      public MedicsController(MedicsService medicsService) {
            this.medicsService = medicsService;
      }

      @ApiOperation(
              nickname = "Microservice para obtener informacion de los medicos activos",
              value = "Obtener informacion de los medicos activos",
              notes = "Informacion de medicos activos."
      )
      @ApiResponses(value = {
              @ApiResponse(code = 400, message = "Bad request.", response = Response400.class),
              @ApiResponse(code = 500, message = "Internal Server Error.",  response = Response500.class)
               })
      @GetMapping(path = "/getMedics")
      public ResponseEntity<Object> getMedics() throws Exception {
            log.info("obteniendo informacion de medicos");
            List<MedicDto> medicDtoList = medicsService.getAllMedics();
            ResponseMessage responseServiceMessage = new ResponseServiceMessage.ResponseServiceMessageBuilder()
                    .withMessage("success")
                    .withData(medicDtoList)
                    .withHttpStatus(HttpStatus.OK)
                    .build();
            return new ResponseEntity<>(responseServiceMessage, HttpStatus.OK);
      }

      @ApiOperation(
              nickname = "Microservice para el registro de medicos",
              value = "Registrar medicos en el sistema",
              notes = "Registrar medicos."
      )
      @ApiResponses(value = {
              @ApiResponse(code = 400, message = "Bad request.", response = Response400.class),
              @ApiResponse(code = 500, message = "Internal Server Error.",  response = Response500.class)
      })
      @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<Object> createMedic(@RequestBody @Valid String request) throws Exception {
            log.info("guardando informacion de medico");
            RequestServiceMessage requestServiceMessage = MapperUtil.gson.fromJson(request, RequestServiceMessage.class);
            medicsService.createMedic(requestServiceMessage);
            ResponseMessage responseServiceMessage = new ResponseServiceMessage.ResponseServiceMessageBuilder()
                    .withMessage("success")
                    .withHttpStatus(HttpStatus.CREATED)
                    .build();
            return new ResponseEntity<>(responseServiceMessage, HttpStatus.CREATED);
      }

      @ApiOperation(
              nickname = "Microservice para modificar datos de medicos",
              value = "Modificar informacion de medicos registrados en sistema",
              notes = "Modificacion de datos del medico."
      )
      @ApiResponses(value = {
              @ApiResponse(code = 400, message = "Bad request.", response = Response400.class),
              @ApiResponse(code = 500, message = "Internal Server Error.",  response = Response500.class)
      })
      @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<Object> updateMedic(@RequestBody @Valid String request) throws Exception {
            log.info("actualizando informacion de medico");
            RequestServiceMessage requestServiceMessage = MapperUtil.gson.fromJson(request, RequestServiceMessage.class);
            medicsService.updateMedic(requestServiceMessage);

            ResponseMessage responseServiceMessage = new ResponseServiceMessage.ResponseServiceMessageBuilder()
                    .withMessage("success")
                    .withHttpStatus(HttpStatus.OK)
                    .build();

            return new ResponseEntity<>(responseServiceMessage, HttpStatus.OK);
      }

      @ApiOperation(
              nickname = "Microservice para dar de baja a medicos",
              value = "Dar de baja a medicos registrados en sistema",
              notes = "Baja de medicos."
      )
      @ApiResponses(value = {
              @ApiResponse(code = 400, message = "Bad request.", response = Response400.class),
              @ApiResponse(code = 500, message = "Internal Server Error.",  response = Response500.class)
      })
      @DeleteMapping(path = "/remove", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<Object> removeMedic(@RequestBody @Valid String request) throws ComponentException
      {
            RequestServiceMessage requestServiceMessage = MapperUtil.gson.fromJson(request, RequestServiceMessage.class);
            log.info("eliminando informacion de medico");
            medicsService.removeMedic(requestServiceMessage);
            ResponseMessage responseServiceMessage = new ResponseServiceMessage.ResponseServiceMessageBuilder()
                    .withMessage("success")
                    .withHttpStatus(HttpStatus.OK)
                    .build();
            return new ResponseEntity<>(responseServiceMessage, HttpStatus.OK);
      }
}
