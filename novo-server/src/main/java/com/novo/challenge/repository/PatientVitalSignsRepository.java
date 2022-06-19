package com.novo.challenge.repository;

import com.novo.challenge.domain.document.PatientVitalSignsDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PatientVitalSignsRepository extends MongoRepository<PatientVitalSignsDocument, String> {
    @Query("{patientId:'?0'}")
    PatientVitalSignsDocument fetchByPatientId(String patientId);

    @Query(value = "{patientId:'?0'}", delete = true)
    void deleteByPatientId(String patientId);
}
