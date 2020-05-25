package com.test.dao.daoImpl;

import com.test.dao.DaoConnection;
import com.test.dao.DaoPatients;
import com.test.model.Patient;
import com.test.model.dbParse.patient.PatientParse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "singleton")
public class DaoPatientsImpl implements DaoPatients {

    private static Logger logger = Logger.getLogger(DaoPatientsImpl.class);

    private DaoConnection daoConnection;

    @Autowired
    public void setDaoConnection(DaoConnection daoConnection) {
        this.daoConnection = daoConnection;
    }

    private PatientParse patientParse;

    @Autowired
    public void setPatientParse(PatientParse patientParse) {
        this.patientParse = patientParse;
    }

    private Patient patient;
    private List<Patient> patients = new ArrayList<>();
    private ResultSet resultSet;
    private PreparedStatement statement;

    @Override
    public List<Patient> selectAllPatient() {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM LAB3MU_PATIENT");
            resultSet = statement.executeQuery();
            patients = patientParse.getAllPatient(resultSet);
            return patients;
        } catch (SQLException e) {
            logger.error("SQLException in selectAllPersonal() ", e);
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                logger.error("error in selectAllPersonal() ", e);
            }
        }
        return patients;
    }

    private void close() {
        try {
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            logger.error("error in close() ", e);
        }
    }

    @Override
    public Patient findByIdPatient(int id) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM LAB3MU_PATIENT WHERE PATIENT_ID = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            patient = patientParse.getPatientBy(resultSet);
            return patient;
        } catch (SQLException e) {
            logger.error("SQLException in findByIdPatient() ", e);
        } finally {
            close();
        }
        return patient;
    }

    @Override
    public List<Patient> getByIdPatientList(int id) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM LAB3MU_PATIENT WHERE PATIENT_ID = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            patients = patientParse.getAllPatient(resultSet);
            return patients;
        } catch (SQLException e) {
            logger.error("SQLException in getByIdPatientList() ", e);
        } finally {
            close();
        }
        return patients;
    }

    @Override
    public List<Patient> findByLastNamePatient(String lastName) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM LAB3MU_PATIENT WHERE LAST_NAME = ?");
            statement.setString(1, lastName);
            resultSet = statement.executeQuery();
            patients = patientParse.getAllPatient(resultSet);
            return patients;
        } catch (SQLException e) {
            logger.error("SQLException in findByLastNamePatient() ", e);
        } finally {
            close();
        }
        return patients;
    }

    @Override
    public void updatePatient(int id, int diagnosisId, int medicineId) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("UPDATE LAB3MU_PATIENT" +
                    " SET DIAGNOSIS_ID = ?, MEDICINE_ID = ? WHERE PATIENT_ID = ?");
            statement.setInt(1, diagnosisId);
            statement.setInt(2, medicineId);
            statement.setInt(3, id);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            logger.error("SQLException in updatePatient() ", e);
        } finally {
            close();
        }
    }

    @Override
    public void deletePatient(int id) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("DELETE LAB3MU_PATIENT WHERE PATIENT_ID = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            logger.error("SQLException in deletePatient() ", e);
        } finally {
            close();
        }
    }

    @Override
    public void createPatient(String firstName, String lastName, String position, int phone, String address, int diagnosisId, int medicineId) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("INSERT INTO LAB3MU_PATIENT " +
                    "(PATIENT_ID, FIRST_NAME, LAST_NAME, POSITION, PHONE, ADDRESS, DIAGNOSIS_ID, MEDICINE_ID)  " +
                    "VALUES (LAB3MU_PATIENT_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, position);
            statement.setInt(4, phone);
            statement.setString(5, address);
            statement.setInt(6, diagnosisId);
            statement.setInt(7, medicineId);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            logger.error("SQLException in createPatient() ", e);
        } finally {
            close();
        }
    }
}
