package com.mx.offices.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.offices.entity.CompositeKey;
import com.mx.offices.entity.Medic;
import com.mx.offices.repository.MedicRepository;
import com.mx.offices.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import utils.ResourceUtil;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "/application.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ControllerTest {

      @Autowired
      private MockMvc mockMvc;

      @Value("${info.microservice.version}")
      private String version;

      @Value("${info.microservice.name}")
      private String name;

      @MockBean
      private MedicRepository medicRepository;

      private static ObjectMapper objectMapper = new ObjectMapper();


      @Test
      void managementTest() throws Exception {
            mockMvc.perform(get("/management/info"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.data.Version").value(version))
                    .andExpect(jsonPath("$.data.Microservice").value(name))
                    .andDo(print())
                    .andReturn();
      }

      @Test
      void getMedics() throws Exception {
            Medic medic = new Medic();
            CompositeKey compositeKey = new CompositeKey();
            compositeKey.setName("Pedro");
            compositeKey.setLastName("Lopez");
            compositeKey.setBirthdate(DateUtil.INSTANCE.stringToDate("1990-04-20"));

            List<Medic> medicList = new ArrayList<>();
            medicList.add(medic);

            Mockito.when(medicRepository.findAllByActive(ArgumentMatchers.anyInt())).thenReturn(medicList);

            String response = ResourceUtil.INSTANCE.getResourceFileAsJson("response/getMedics_200.json");
            mockMvc.perform(
                    get("/api/medics/getMedics"))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn();
      }

      @Test
      void create() throws Exception {
            Medic medic = new Medic();
            CompositeKey compositeKey = new CompositeKey();
            compositeKey.setName("Pedro");
            compositeKey.setLastName("Lopez");
            compositeKey.setBirthdate(DateUtil.INSTANCE.stringToDate("1990-04-20"));

            List<Medic> medicList = new ArrayList<>();
            medicList.add(medic);

            Mockito.when(medicRepository.saveAll(ArgumentMatchers.any())).thenReturn(medicList);
            String request = ResourceUtil.INSTANCE.getResourceFileAsJson("request/createMedic.json");
            mockMvc.perform(post("/api/medics/create")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(request)
                    ).andExpect(status().isCreated())
                    .andDo(print())
                    .andReturn();
      }

      @Test
      void update() throws Exception {
            Medic medic = new Medic();
            CompositeKey compositeKey = new CompositeKey();
            compositeKey.setName("Pedro");
            compositeKey.setLastName("Lopez");
            compositeKey.setBirthdate(DateUtil.INSTANCE.stringToDate("1990-04-20"));

            List<Medic> medicList = new ArrayList<>();
            medicList.add(medic);

            Mockito.when(medicRepository.saveAll(ArgumentMatchers.any())).thenReturn(medicList);
            String request = ResourceUtil.INSTANCE.getResourceFileAsJson("request/updateMedic.json");
            mockMvc.perform(put("/api/medics/update")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(request)
                    ).andExpect(status().isOk())
                    .andDo(print())
                    .andReturn();
      }

      @Test
      void remove() throws Exception {
            Medic medic = new Medic();
            CompositeKey compositeKey = new CompositeKey();
            compositeKey.setName("Pedro");
            compositeKey.setLastName("Lopez");
            compositeKey.setBirthdate(DateUtil.INSTANCE.stringToDate("1990-04-20"));

            List<Medic> medicList = new ArrayList<>();
            medicList.add(medic);

            Mockito.when(medicRepository.findByNamesAndLastNameAndBirthdateAndStatus(ArgumentMatchers.any())).thenReturn(medicList);
            String request = ResourceUtil.INSTANCE.getResourceFileAsJson("request/removeMedic.json");
            Mockito.when(medicRepository.saveAll(ArgumentMatchers.any())).thenReturn(medicList);
            mockMvc.perform(delete("/api/medics/remove")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(request)
                    ).andExpect(status().isOk())
                    .andDo(print())
                    .andReturn();
      }

}
