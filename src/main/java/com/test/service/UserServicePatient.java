package com.test.service;

import com.test.model.Patient;

import java.util.List;

public interface UserServicePatient {

    List<Patient> allPatient();

    void updatePatient(int id, int diagnosisId, int medicineId);

    Patient getByIdPatient(int id);

    void deletePatient(int id);

    List<Patient> getByIdPatientList(int id);

    List<Patient> findByLastNamePatient(String lastName);

    void createPatient(String firstName, String lastName, String position, int phone, String address, int diagnosisId, int medicineId);
}
