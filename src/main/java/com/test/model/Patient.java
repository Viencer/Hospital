package com.test.model;

import java.util.Objects;

public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private String position;
    private String phone;
    private String address;
    private int diagnosisId;
    private int medicineId;

    public Patient() {
    }

    public Patient(int id, String firstName, String lastName, String position, String phone, String address, int diagnosisId, int medicineId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.phone = phone;
        this.address = address;
        this.diagnosisId = diagnosisId;
        this.medicineId = medicineId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getId() == patient.getId() &&
                getDiagnosisId() == patient.getDiagnosisId() &&
                getMedicineId() == patient.getMedicineId() &&
                Objects.equals(getFirstName(), patient.getFirstName()) &&
                Objects.equals(getLastName(), patient.getLastName()) &&
                Objects.equals(getPosition(), patient.getPosition()) &&
                Objects.equals(getPhone(), patient.getPhone()) &&
                Objects.equals(address, patient.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getPosition(), getPhone(), address, getDiagnosisId(), getMedicineId());
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", diagnosisId=" + diagnosisId +
                ", medicineId=" + medicineId +
                '}';
    }
}
