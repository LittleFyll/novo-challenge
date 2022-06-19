package com.novo.challenge.service;

import com.novo.challenge.domain.assembler.PatientAssembler;
import com.novo.challenge.domain.document.PatientDocument;
import com.novo.challenge.domain.dto.PatientDto;
import com.novo.challenge.domain.dto.PatientVitalSignsDto;
import com.novo.challenge.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/*
* The Repository act as a Dao, we should rename it as a Dao and create a proper Repository layer
* Since we don't really need to have business logic, the service directly convert the Dto for the Dao (should be Dto -> POJO -> Document)
* */
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository repository;
    @Autowired
    private PatientVitalSignsService patientVitalSignsService;
    @Autowired
    private PatientAssembler assembler;
    private final Random random = new Random();

    @Override
    public void createPatient(PatientDto patientDto) {
        PatientDocument savedPatientDocument = repository.save(assembler.assemble(patientDto));
        patientVitalSignsService.createPatientVitals(mockVitalSigns(savedPatientDocument.getId()));
    }

    @Override
    public void deleteById(String patientId) {
        repository.deleteById(patientId);
        patientVitalSignsService.deleteByPatientId(patientId);
    }

    @Override
    public List<PatientDto> findAll() {
        return repository.findAll().stream().map(assembler::assemble).collect(Collectors.toList());
    }

    private PatientVitalSignsDto mockVitalSigns(String patientId) {
        var vitalSignsDto = new PatientVitalSignsDto();
        vitalSignsDto.setPatientId(patientId);
        vitalSignsDto.setHeartRate(Arrays.stream(new double[30]).map(d -> randomWithRange(50,120,0)).toArray());
        vitalSignsDto.setTemperature(Arrays.stream(new double[20]).map(d -> randomWithRange(35,40,2)).toArray());
        vitalSignsDto.setOxygenSaturation(Arrays.stream(new double[10]).map(d -> randomWithRange(90,100,1)).toArray());
        return vitalSignsDto;
    }

    private double randomWithRange(int lowerBound, int upperBound, int digits) {
        double digitsToKeep = Math.pow(10, digits);
        return random.nextInt((upperBound - lowerBound) * (int) digitsToKeep) / digitsToKeep + lowerBound;
    }
}
