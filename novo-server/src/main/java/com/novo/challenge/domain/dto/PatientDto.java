package com.novo.challenge.domain.dto;

import com.novo.challenge.domain.model.Sexe;
import com.novo.challenge.infra.EnumValidator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Objects;

public class PatientDto {
    private String id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Past
    private LocalDate birthday;

    @EnumValidator(enumClass = Sexe.class, message = "must be MALE/FEMALE/NOT_SPECIFIED")
    private String sexe;

    @NotEmpty
    @Email
    private String email;

    public PatientDto() {
    }

    public PatientDto(String id, String firstName, String lastName, LocalDate birthday, String sexe, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.sexe = sexe;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDto that = (PatientDto) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(birthday, that.birthday) && Objects.equals(sexe, that.sexe) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthday, sexe, email);
    }
}
