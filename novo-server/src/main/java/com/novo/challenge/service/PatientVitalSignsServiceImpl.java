package com.novo.challenge.service;

import com.novo.challenge.domain.assembler.PatientVitalSignsAssembler;
import com.novo.challenge.domain.document.PatientVitalSignsDocument;
import com.novo.challenge.domain.dto.PatientVitalSignsDto;
import com.novo.challenge.repository.PatientVitalSignsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*
* The Repository act as a Dao, we should rename it as a Dao and create a proper Repository layer
* Since we don't really need to have business logic, the service directly convert the Dto for the Dao (should be Dto -> POJO -> Document)
* */
@Service
public class PatientVitalSignsServiceImpl implements PatientVitalSignsService {
    @Autowired
    PatientVitalSignsRepository repository;
    @Autowired
    PatientVitalSignsAssembler assembler;

    @Override
    public PatientVitalSignsDto findPatientVitalSigns(String patientId) {
        return assembler.assemble(repository.fetchByPatientId(patientId));
    }

    @Override
    public void createPatientVitals(PatientVitalSignsDto patientVitalSignsDto) {
        repository.save(assembler.assemble(patientVitalSignsDto));
    }

    @Override
    public void deleteByPatientId(String patientId) {
        repository.deleteByPatientId(patientId);
    }
}
