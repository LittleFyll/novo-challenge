package com.novo.challenge.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.novo.challenge.domain.dto.PatientDto;
import com.novo.challenge.service.PatientServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@ContextConfiguration(classes = {PatientController.class})
@WebMvcTest
@AutoConfigureMockMvc
class PatientControllerIT {
    private final String ID = "id";
    private final String FIRST_NAME = "first";
    private final String LAST_NAME = "last";
    private final LocalDate BIRTDAY = LocalDate.of(1995, 1, 30);
    private final String SEXE = "MALE";
    private final String EMAIL = "test@domain.com";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenValidPatientDto_whenCreatePatient_thenStatusIsCreated() throws Exception {
        var patientDto = givenPatientDto();
        mockMvc.perform(MockMvcRequestBuilders.post("/patient").content(toJson(patientDto)).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void givenPatientDtoWithNoFirstName_whenCreatePatient_thenStatusIsBadRequest() throws Exception {
        var patientDto = givenPatientDto();
        patientDto.setFirstName(null);
        mockMvc.perform(MockMvcRequestBuilders.post("/patient").content(toJson(patientDto)).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void givenPatientDtoWithNoLastName_whenCreatePatient_thenStatusIsBadRequest() throws Exception {
        var patientDto = givenPatientDto();
        patientDto.setLastName(null);
        mockMvc.perform(MockMvcRequestBuilders.post("/patient").content(toJson(patientDto)).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void givenPatientDtoWithWrongSexe_whenCreatePatient_thenStatusIsBadRequest() throws Exception {
        var patientDto = givenPatientDto();
        patientDto.setSexe("invalidValue");
        mockMvc.perform(MockMvcRequestBuilders.post("/patient").content(toJson(patientDto)).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void givenPatientDtoWithFutureBirthdaty_whenCreatePatient_thenStatusIsBadRequest() throws Exception {
        var patientDto = givenPatientDto();
        patientDto.setBirthday(LocalDate.of(2999, 1, 1));
        mockMvc.perform(MockMvcRequestBuilders.post("/patient").content(toJson(patientDto)).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


    private PatientDto givenPatientDto() {
        return new PatientDto(ID, FIRST_NAME, LAST_NAME, BIRTDAY, SEXE, EMAIL);
    }

    private String toJson(Object dto) {
        String json = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            json = mapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

}