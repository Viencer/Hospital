package com.test.dao.daoImpl;

import com.test.dao.DaoConnection;
import com.test.dao.DaoOtherTables;
import com.test.model.*;
import com.test.model.dbParse.otherTables.OtherTablesParse;
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
public class DaoOtherTablesImpl implements DaoOtherTables {
    private static Logger logger = Logger.getLogger(DaoOtherTablesImpl.class);


    private DaoConnection daoConnection;

    @Autowired
    public void setDaoConnection(DaoConnection daoConnection) {
        this.daoConnection = daoConnection;
    }

    private OtherTablesParse otherTablesParse;

    @Autowired
    public void setOtherTablesParse(OtherTablesParse otherTablesParse) {
        this.otherTablesParse = otherTablesParse;
    }

    private List<Medicine> medicines = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private List<Diagnosis> diagnoses = new ArrayList<>();
    private List<Jobs> jobs = new ArrayList<>();
    private List<Treatment> treatments = new ArrayList<>();
    private ResultSet resultSet;
    private PreparedStatement statement;

    private void close() {
        try {
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            logger.error("error in close() ", e);
        }
    }


    @Override
    public List<Department> getAllDepartments() {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM LAB3MU_DEPARTMENT");
            resultSet = statement.executeQuery();
            departments = otherTablesParse.getAllDepartments(resultSet);
            return departments;
        } catch (SQLException e) {
            logger.error("SQLException in getAllDepartments() ", e);
        } finally {
            close();
        }
        return departments;
    }

    @Override
    public List<Diagnosis> getAllDiagnosis() {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM LAB3MU_DIAGNOSIS");
            resultSet = statement.executeQuery();
            diagnoses = otherTablesParse.getAllDiagnosis(resultSet);
            return diagnoses;
        } catch (SQLException e) {
            logger.error("SQLException in getAllDiagnosis() ", e);
        } finally {
            close();
        }
        return diagnoses;
    }

    @Override
    public List<Jobs> getAllJobs() {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM LAB3MU_JOBS");
            resultSet = statement.executeQuery();
            jobs = otherTablesParse.getAllJobs(resultSet);
            return jobs;
        } catch (SQLException e) {
            logger.error("SQLException in getAllJobs() ", e);
        } finally {
            close();
        }
        return jobs;
    }

    @Override
    public List<Medicine> getAllMedicines() {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM LAB3MU_MEDICINE");
            resultSet = statement.executeQuery();
            medicines = otherTablesParse.getAllMedicine(resultSet);
            return medicines;
        } catch (SQLException e) {
            logger.error("SQLException in getAllMedicines() ", e);
        } finally {
            close();
        }
        return medicines;
    }

    @Override
    public List<Treatment> getAllTreatments() {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM LAB3MU_TREATMENT");
            resultSet = statement.executeQuery();
            treatments = otherTablesParse.getAllTreatment(resultSet);
            return treatments;
        } catch (SQLException e) {
            logger.error("SQLException in getAllTreatments() ", e);
        } finally {
            close();
        }
        return treatments;
    }
}
