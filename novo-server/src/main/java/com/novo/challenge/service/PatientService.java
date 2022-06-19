package com.novo.challenge.service;

import com.novo.challenge.domain.dto.PatientDto;

import java.util.List;

public interface PatientService {
    void createPatient(PatientDto patientDto);
    void deleteById(String patientId);

    List<PatientDto> findAll();
}
