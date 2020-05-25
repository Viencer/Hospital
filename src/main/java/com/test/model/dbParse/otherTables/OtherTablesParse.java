package com.test.model.dbParse.otherTables;

import com.test.model.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OtherTablesParse {

    private static Logger logger = Logger.getLogger(OtherTablesParse.class);

    private Medicine medicine;
    private Department department;
    private Diagnosis diagnosis;
    private Jobs job;
    private Treatment treatment;

    public List<Department> getAllDepartments(ResultSet resultSet) {
        List<Department> departments = new ArrayList<Department>();
        try {
            while (resultSet.next()) {
                int department_id = resultSet.getInt("DEPARTMENT_ID");
                String department_name = resultSet.getString("DEPARTMENT_NAME");
                int department_budget = resultSet.getInt("DEPARTMENT_BUDGET");
                department = new Department(department_id, department_name, department_budget);
                departments.add(department);
            }
        } catch (SQLException e) {
            logger.error("SQLException in getAllDepartment() ", e);
        }
        return departments;
    }

    public List<Diagnosis> getAllDiagnosis(ResultSet resultSet) {
        List<Diagnosis> diagnoses = new ArrayList<Diagnosis>();
        try {
            while (resultSet.next()) {
                int diagnosis_id = resultSet.getInt("DIAGNOSIS_ID");
                int day_to_death = resultSet.getInt("DAY_TO_DEATH");
                String diagnosis_name = resultSet.getString("DIAGNOSIS_NAME");
                int treatment_id = resultSet.getInt("TREATMENT_ID");
                diagnosis = new Diagnosis(diagnosis_id, day_to_death, diagnosis_name, treatment_id);
                diagnoses.add(diagnosis);
            }
        } catch (SQLException e) {
            logger.error("SQLException in getAllDiagnosis() ", e);
        }
        return diagnoses;
    }

    public List<Jobs> getAllJobs(ResultSet resultSet) {
        List<Jobs> jobs = new ArrayList<Jobs>();
        try {
            while (resultSet.next()) {
                int job_id = resultSet.getInt("JOB_ID");
                String job_name = resultSet.getString("JOB_NAME");
                int min_salary = resultSet.getInt("MIN_SALARY");
                int max_salary = resultSet.getInt("MAX_SALARY");
                job = new Jobs(job_id, job_name, min_salary, max_salary);
                jobs.add(job);
            }
        } catch (SQLException e) {
            logger.error("SQLException in getAllJobs() ", e);
        }
        return jobs;
    }

    public List<Treatment> getAllTreatment(ResultSet resultSet) {
        List<Treatment> treatments = new ArrayList<Treatment>();
        try {
            while (resultSet.next()) {
                int treatment_id = resultSet.getInt("TREATMENT_ID");
                String name_of_treatment = resultSet.getString("NAME_OF_TREATMENT");
                int duration_days = resultSet.getInt("DURATION_DAYS");
                treatment = new Treatment(treatment_id, name_of_treatment, duration_days);
                treatments.add(treatment);
            }
        } catch (SQLException e) {
            logger.error("SQLException in getAllTreatment() ", e);
        }
        return treatments;
    }

    public List<Medicine> getAllMedicine(ResultSet resultSet) {
        List<Medicine> medicines = new ArrayList<Medicine>();
        try {
            while (resultSet.next()) {
                int medicine_id = resultSet.getInt("MEDICINE_ID");
                String medicine_name = resultSet.getString("MEDICINE_NAME");
                int admission_days = resultSet.getInt("ADMISSION_DAYS");
                String provider_name = resultSet.getString("PROVIDER_NAME");
                medicine = new Medicine(medicine_id, medicine_name, admission_days, provider_name);
                medicines.add(medicine);
            }
        } catch (SQLException e) {
            logger.error("SQLException in getAllMedicine() ", e);
        }
        return medicines;
    }

}
