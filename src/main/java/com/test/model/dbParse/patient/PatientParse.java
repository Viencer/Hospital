package com.test.model.dbParse.patient;

import com.test.model.Patient;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PatientParse {

    private static Logger logger = Logger.getLogger(PatientParse.class);

    private Patient patient;

    public Patient getPatientBy(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                patient = getPatient(resultSet);
            }
        } catch (SQLException e) {
            logger.error("SQLException in getPatientBy() ", e);
        }
        return patient;
    }

    public List<Patient> getAllPatient(ResultSet resultSet) {
        List<Patient> patients = new ArrayList<Patient>();
        try {
            while (resultSet.next()) {
                patients.add(getPatient(resultSet));
            }
        } catch (SQLException e) {
            logger.error("SQLException in getAllPatient()", e);
        }
        return patients;
    }

    private Patient getPatient(ResultSet resultSet) {
        try {
            int patient_id = resultSet.getInt("PATIENT_ID");
            String first_name = resultSet.getString("FIRST_NAME");
            String last_name = resultSet.getString("LAST_NAME");
            String position = resultSet.getString("POSITION");
            String phone = resultSet.getString("PHONE");
            String address = resultSet.getString("ADDRESS");
            int diagnosis_id = resultSet.getInt("DIAGNOSIS_ID");
            int medicine_id = resultSet.getInt("MEDICINE_ID");
            patient = new Patient(patient_id, first_name, last_name, position, phone, address, diagnosis_id, medicine_id);
        } catch (SQLException e) {
            logger.error("SQLException in getPatient() method. ", e);
        }
        return patient;
    }
}
