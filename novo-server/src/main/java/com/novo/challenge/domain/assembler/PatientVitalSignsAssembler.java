package com.novo.challenge.domain.assembler;

import com.novo.challenge.domain.document.PatientVitalSignsDocument;
import com.novo.challenge.domain.dto.PatientVitalSignsDto;
import org.springframework.stereotype.Component;

@Component
public class PatientVitalSignsAssembler {
    public PatientVitalSignsDto assemble(PatientVitalSignsDocument document) {
        var dto = new PatientVitalSignsDto();
        dto.setPatientId(document.getPatientId());
        dto.setHeartRate(document.getHeartRate());
        dto.setTemperature(document.getTemperature());
        dto.setOxygenSaturation(document.getOxygenSaturation());
        return dto;
    }

    public PatientVitalSignsDocument assemble(PatientVitalSignsDto dto) {
        var document = new PatientVitalSignsDocument();
        document.setPatientId(dto.getPatientId());
        document.setHeartRate(dto.getHeartRate());
        document.setTemperature(dto.getTemperature());
        document.setOxygenSaturation(dto.getOxygenSaturation());
        return document;
    }
}
