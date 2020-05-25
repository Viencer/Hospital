package com.test.model;

import java.util.Objects;

public class Diagnosis {
    private int diagnosisId;
    private int dayToDeath;
    private String diagnosisName;
    private int treatmentId;

    public Diagnosis() {
    }

    public Diagnosis(int diagnosisId, int dayToDeath, String diagnosisName, int treatmentId) {
        this.diagnosisId = diagnosisId;
        this.dayToDeath = dayToDeath;
        this.diagnosisName = diagnosisName;
        this.treatmentId = treatmentId;
    }

    public int getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public int getDayToDeath() {
        return dayToDeath;
    }

    public void setDayToDeath(int dayToDeath) {
        this.dayToDeath = dayToDeath;
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diagnosis)) return false;
        Diagnosis diagnosis = (Diagnosis) o;
        return getDiagnosisId() == diagnosis.getDiagnosisId() &&
                getDayToDeath() == diagnosis.getDayToDeath() &&
                getTreatmentId() == diagnosis.getTreatmentId() &&
                Objects.equals(getDiagnosisName(), diagnosis.getDiagnosisName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiagnosisId(), getDayToDeath(), getDiagnosisName(), getTreatmentId());
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "diagnosisId=" + diagnosisId +
                ", dayToDeath=" + dayToDeath +
                ", diagnosisName='" + diagnosisName + '\'' +
                ", treatmentId=" + treatmentId +
                '}';
    }
}
