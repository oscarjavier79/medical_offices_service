package com.mx.offices.service.impl;


import com.fasterxml.jackson.core.type.TypeReference;
import com.mx.offices.dto.CareDto;
import com.mx.offices.dto.MedicDto;
import com.mx.offices.dto.MedicRemoveDto;
import com.mx.offices.dto.RequestServiceMessage;
import com.mx.offices.entity.Care;
import com.mx.offices.entity.Medic;
import com.mx.offices.exceptions.ComponentException;
import com.mx.offices.exceptions.ErrorMessage;
import com.mx.offices.repository.CareRepository;
import com.mx.offices.service.CareService;
import com.mx.offices.service.MapeoService;
import com.mx.offices.service.MedicsService;
import com.mx.offices.utils.Constants;
import com.mx.offices.utils.MapperUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class CareServiceImpl implements CareService {

    CareRepository careRepository;

    public CareServiceImpl(CareRepository careRepository) {
        this.careRepository = careRepository;
    }

    @Override
    public List<CareDto> getAllCares() throws Exception {
        List<Care> cares = careRepository.findAllByActive(Constants.ENABLE);
        return Collections.emptyList();
    }

    @Override
    public void createCare(RequestServiceMessage request) {
        List<CareDto> cares = MapperUtil.objectMapper.convertValue(request.getData(), new TypeReference<List<CareDto>>(){});
        List<Care> cCare = cares.stream()
                .map(obj -> {
                    Care care = new Care();
                    care.setId(obj.getId());
                    care.setPatientId(UUID.fromString(obj.getPatientId()));
                    care.setMedicId(UUID.fromString(obj.getMedicId()));
                    care.setMedicalOfficeId(UUID.fromString(obj.getMedicalOfficeId()));
                    care.setAttentionDate(obj.getAttentionDate());
                    care.setActive(obj.getActive());
                    care.setCreatedAt(obj.getCreatedAt());
                    care.setUpdatedAt(obj.getUpdatedAt());
                    return care;
                })
                .collect(Collectors.toList());
        careRepository.saveAll(cCare);
    }

    @Override
    public void updateCare(RequestServiceMessage request) {
        List<CareDto> cares = MapperUtil.objectMapper.convertValue(request.getData(), new TypeReference<List<CareDto>>(){});
        List<Care> cCare = cares.stream()
                .map(obj -> {
                    Care care = new Care();
                    care.setId(obj.getId());
                    care.setPatientId(UUID.fromString(obj.getPatientId()));
                            care.setMedicId(UUID.fromString(obj.getMedicId()));
                                    care.setMedicalOfficeId(UUID.fromString(obj.getMedicalOfficeId()));
                                            care.setAttentionDate(obj.getAttentionDate());
                                                    care.setActive(obj.getActive());
                                                            care.setCreatedAt(obj.getCreatedAt());
                                                                    care.setUpdatedAt(obj.getUpdatedAt());
                    return care;
                })
                .collect(Collectors.toList());
        careRepository.saveAll(cCare);
    }

    public Care convertTo(CareDto careDto) {
        Care cCare = new Care();
        cCare.setActive(careDto.getActive());
        cCare.setCreatedAt(careDto.getCreatedAt());
        cCare.setAttentionDate(careDto.getAttentionDate());
        cCare.setMedicId(UUID.fromString(careDto.getMedicId()));
        cCare.setPatientId(UUID.fromString(careDto.getPatientId()));
        cCare.setMedicalOfficeId(UUID.fromString(careDto.getMedicalOfficeId()));
        return cCare;
    }
    public CareDto convertFrom(Care care, CareDto careDTO) {
        return new CareDto(care.getId(),care.getPatientId().toString(), care.getMedicId().toString(), care.getMedicalOfficeId().toString(),
                care.getAttentionDate(), care.getActive(), care.getCreatedAt(), care.getUpdatedAt());
    }

}
