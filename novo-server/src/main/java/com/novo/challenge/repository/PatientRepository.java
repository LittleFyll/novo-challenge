package com.novo.challenge.repository;

import com.novo.challenge.domain.document.PatientDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<PatientDocument, String> {
}
