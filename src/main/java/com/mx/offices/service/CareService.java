package com.mx.offices.service;


import com.mx.offices.dto.CareDto;
import com.mx.offices.dto.MedicDto;
import com.mx.offices.dto.RequestServiceMessage;
import com.mx.offices.exceptions.ComponentException;

import java.util.List;

public interface CareService {

    List<CareDto> getAllCares() throws Exception;
    void createCare(RequestServiceMessage requestServiceMessage) throws Exception;
    void updateCare(RequestServiceMessage requestServiceMessage) throws Exception;
}
