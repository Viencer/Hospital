package com.test.dao;

import com.test.model.Patient;

import java.util.List;

public interface DaoPatients {

    List<Patient> selectAllPatient();

    Patient findByIdPatient(int id);

    List<Patient> getByIdPatientList(int id);

    List<Patient> findByLastNamePatient(String lastName);

    void updatePatient(int id, int diagnosisId, int medicineId);

    void deletePatient(int id);

    void createPatient(String firstName, String lastName, String position, int phone,
                       String address, int diagnosisId, int medicineId);
}
