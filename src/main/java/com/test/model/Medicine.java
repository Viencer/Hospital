package com.test.model;

import java.util.Objects;

public class Medicine {
    private int medicineId;
    private String medicineName;
    private int admissionDays;
    private String providerName;

    public Medicine() {
    }

    public Medicine(int medicineId, String medicineName, int admissionDays, String providerName) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.admissionDays = admissionDays;
        this.providerName = providerName;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getAdmissionDays() {
        return admissionDays;
    }

    public void setAdmissionDays(int admissionDays) {
        this.admissionDays = admissionDays;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicine)) return false;
        Medicine medicine = (Medicine) o;
        return getMedicineId() == medicine.getMedicineId() &&
                getAdmissionDays() == medicine.getAdmissionDays() &&
                Objects.equals(getMedicineName(), medicine.getMedicineName()) &&
                Objects.equals(getProviderName(), medicine.getProviderName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMedicineId(), getMedicineName(), getAdmissionDays(), getProviderName());
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineId=" + medicineId +
                ", medicineName='" + medicineName + '\'' +
                ", admissionDays=" + admissionDays +
                ", providerName='" + providerName + '\'' +
                '}';
    }
}
