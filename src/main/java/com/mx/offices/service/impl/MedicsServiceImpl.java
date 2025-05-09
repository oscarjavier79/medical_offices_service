package com.mx.offices.service.impl;


import com.fasterxml.jackson.core.type.TypeReference;
import com.mx.offices.dto.MedicDto;
import com.mx.offices.dto.MedicRemoveDto;
import com.mx.offices.dto.RequestServiceMessage;
import com.mx.offices.entity.Medic;
import com.mx.offices.exceptions.ComponentException;
import com.mx.offices.exceptions.ErrorMessage;
import com.mx.offices.repository.MedicRepository;
import com.mx.offices.service.MapeoService;
import com.mx.offices.service.MedicsService;
import com.mx.offices.utils.Constants;
import com.mx.offices.utils.MapperUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;


@Service
public class MedicsServiceImpl implements MedicsService {

    MedicRepository medicRepository;

    public MedicsServiceImpl(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    @Override
    public List<MedicDto> getAllMedics() throws Exception {
        List<Medic> medics = medicRepository.findAllByActive(Constants.ENABLE);
        return Collections.emptyList();
    }

    @Override
    public void createMedic(RequestServiceMessage request) {
        List<MedicDto> medics = MapperUtil.objectMapper.convertValue(request.getData(), new TypeReference<List<MedicDto>>(){});

    }

    @Override
    public void updateMedic(RequestServiceMessage request) {
        List<MedicDto> medics = MapperUtil.objectMapper.convertValue(request.getData(), new TypeReference<List<MedicDto>>(){});

    }

    @Override
    public void removeMedic(RequestServiceMessage request) throws ComponentException {
        List<MedicRemoveDto> medics = MapperUtil.objectMapper.convertValue(request.getData(), new TypeReference<List<MedicRemoveDto>>(){});
        List<String> names = medics.stream().map(medicRemoveDto -> {
            StringJoiner sJ = new StringJoiner(" ");
            sJ.add(medicRemoveDto.getName());
            sJ.add(medicRemoveDto.getLastName());
            sJ.add(medicRemoveDto.getBirthdate());
            return sJ.toString();
        }).collect(Collectors.toList());
        List<Medic> medicsToRemove = medicRepository.findByNamesAndLastNameAndBirthdateAndStatus(names);
        if(medicsToRemove.isEmpty()){
            ErrorMessage errorMessage = new ErrorMessage.ErrorMessageBuilder()
                    .withCode("15330710")
                    .withMessage("ERROR_MESSAGE")
                    .withLevel("ERROR")
                    .withEvent("event")
                    .withHttpStatus(HttpStatus.BAD_REQUEST.value())
                    .build();
            throw new ComponentException.ComponentExceptionBuilder().withErrorMessage(errorMessage)
                    .withRequestServiceMessage(request).build();
        }
        medicsToRemove.forEach(medic -> medic.setActive(0));
        medicRepository.saveAll(medicsToRemove);
    }

}
