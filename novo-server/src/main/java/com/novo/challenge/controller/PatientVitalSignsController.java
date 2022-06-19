package com.novo.challenge.controller;

import com.novo.challenge.domain.dto.PatientVitalSignsDto;
import com.novo.challenge.service.PatientVitalSignsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/vitalSigns")
@Validated
public class PatientVitalSignsController {
    @Autowired
    private PatientVitalSignsService patientVitalSignsService;

    @GetMapping(value = "/{patientId}")
    public PatientVitalSignsDto findPatientVitalSigns(@PathVariable("patientId") String patientId) {
        return patientVitalSignsService.findPatientVitalSigns(patientId);
    }
}
