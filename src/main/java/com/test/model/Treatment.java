package com.test.model;

import java.util.Objects;

public class Treatment {
    private int treatmentId;
    private String nameOfTreatment;
    private int durationDays;

    public Treatment() {
    }

    public Treatment(int treatmentId, String nameOfTreatment, int durationDays) {
        this.treatmentId = treatmentId;
        this.nameOfTreatment = nameOfTreatment;
        this.durationDays = durationDays;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getNameOfTreatment() {
        return nameOfTreatment;
    }

    public void setNameOfTreatment(String nameOfTreatment) {
        this.nameOfTreatment = nameOfTreatment;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Treatment)) return false;
        Treatment treatment = (Treatment) o;
        return getTreatmentId() == treatment.getTreatmentId() &&
                getDurationDays() == treatment.getDurationDays() &&
                Objects.equals(getNameOfTreatment(), treatment.getNameOfTreatment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTreatmentId(), getNameOfTreatment(), getDurationDays());
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "treatmentId=" + treatmentId +
                ", nameOfTreatment='" + nameOfTreatment + '\'' +
                ", durationDays=" + durationDays +
                '}';
    }
}
