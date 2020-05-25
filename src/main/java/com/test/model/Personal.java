package com.test.model;

import java.util.Objects;

public class Personal {
    private int id;
    private String firstName;
    private String lastName;
    private int jobId;
    private int bossID;
    private int salary;
    private int premium;
    private int department_id;
    private Integer patient_id;

    public Personal() {
    }

    public Personal(int id, String firstName, String lastName, int jobId, int bossID,
                    int salary, int premium, int department_id, int patient_id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobId = jobId;
        this.bossID = bossID;
        this.salary = salary;
        this.premium = premium;
        this.department_id = department_id;
        this.patient_id = patient_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBossID() {
        return bossID;
    }

    public void setBossID(int bossID) {
        this.bossID = bossID;
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

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personal)) return false;
        Personal personal = (Personal) o;
        return getId() == personal.getId() &&
                getJobId() == personal.getJobId() &&
                getBossID() == personal.getBossID() &&
                getSalary() == personal.getSalary() &&
                getPremium() == personal.getPremium() &&
                getDepartment_id() == personal.getDepartment_id() &&
                getPatient_id() == personal.getPatient_id() &&
                Objects.equals(getFirstName(), personal.getFirstName()) &&
                Objects.equals(getLastName(), personal.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getJobId(), getBossID(), getSalary(), getPremium(), getDepartment_id(), getPatient_id());
    }

    @Override
    public String toString() {
        return "Personal{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobId=" + jobId +
                ", bossID=" + bossID +
                ", salary=" + salary +
                ", premium=" + premium +
                ", department_id=" + department_id +
                ", patient_id=" + patient_id +
                '}';
    }
}
