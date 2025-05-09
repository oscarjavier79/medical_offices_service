package com.mx.offices.service;


import com.mx.offices.dto.MedicDto;
import com.mx.offices.dto.RequestServiceMessage;
import com.mx.offices.exceptions.ComponentException;

import java.util.List;

public interface MedicsService {

    List<MedicDto> getAllMedics() throws Exception;

    void createMedic(RequestServiceMessage requestServiceMessage) throws Exception;
    void updateMedic(RequestServiceMessage requestServiceMessage) throws Exception;

    void removeMedic(RequestServiceMessage request) throws ComponentException;
}
