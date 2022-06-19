package com.novo.challenge.controller;

import com.novo.challenge.domain.dto.PatientDto;
import com.novo.challenge.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/patients")
@Validated
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPatient(@Valid @RequestBody PatientDto patientDto) {
        patientService.createPatient(patientDto);

    }

    @GetMapping()
    public ResponseEntity<List<PatientDto>> findAll() {
        List<PatientDto> patientDtos = patientService.findAll();
        return new ResponseEntity<>(patientDtos, patientDtos.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @DeleteMapping(value = "/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("patientId") String patientId) {
        patientService.deleteById(patientId);
    }
}
