package com.novo.challenge.domain.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("patientVitalSigns")
public class PatientVitalSignsDocument {
    @Id
    private String id;

    private String patientId;
    private double[] heartRate;
    private double[] temperature;
    private double[] oxygenSaturation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
