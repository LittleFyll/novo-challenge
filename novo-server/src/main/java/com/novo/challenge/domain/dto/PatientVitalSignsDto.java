package com.novo.challenge.domain.dto;

import java.util.Arrays;
import java.util.Objects;

public class PatientVitalSignsDto {
    private String patientId;
    private double[] heartRate;
    private double[] temperature;
    private double[] oxygenSaturation;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public double[] getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double[] heartRate) {
        this.heartRate = heartRate;
    }

    public double[] getTemperature() {
        return temperature;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }

    public double[] getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(double[] oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientVitalSignsDto that = (PatientVitalSignsDto) o;
        return Objects.equals(patientId, that.patientId) && Arrays.equals(heartRate, that.heartRate) && Arrays.equals(temperature, that.temperature) && Arrays.equals(oxygenSaturation, that.oxygenSaturation);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(patientId);
        result = 31 * result + Arrays.hashCode(heartRate);
        result = 31 * result + Arrays.hashCode(temperature);
        result = 31 * result + Arrays.hashCode(oxygenSaturation);
        return result;
    }
}
