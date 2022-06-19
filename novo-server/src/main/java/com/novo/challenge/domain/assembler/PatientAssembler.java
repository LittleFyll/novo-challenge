package com.novo.challenge.domain.assembler;

import com.novo.challenge.domain.document.PatientDocument;
import com.novo.challenge.domain.dto.PatientDto;
import org.springframework.stereotype.Component;

@Component
public class PatientAssembler {
    public PatientDto assemble(PatientDocument document) {
        var dto = new PatientDto();
        dto.setId(document.getId());
        dto.setFirstName(document.getFirstName());
        dto.setLastName(document.getLastName());
        dto.setBirthday(document.getBirthday());
        dto.setSexe(document.getSexe());
        dto.setEmail(document.getEmail());
        return dto;
    }

    public PatientDocument assemble(PatientDto dto) {
        var document = new PatientDocument();
        document.setId(dto.getId());
        document.setFirstName(dto.getFirstName());
        document.setLastName(dto.getLastName());
        document.setBirthday(dto.getBirthday());
        document.setSexe(dto.getSexe());
        document.setEmail(dto.getEmail());
        return document;
    }
}
