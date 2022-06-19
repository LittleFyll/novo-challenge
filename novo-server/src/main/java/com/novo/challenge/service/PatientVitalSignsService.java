package com.novo.challenge.service;

import com.novo.challenge.domain.dto.PatientVitalSignsDto;

public interface PatientVitalSignsService {
    PatientVitalSignsDto findPatientVitalSigns(String patientId);
    void createPatientVitals(PatientVitalSignsDto patientVitalSignsDto);
    void deleteByPatientId(String patientId);
}
