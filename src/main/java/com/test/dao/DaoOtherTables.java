package com.test.dao;

import com.test.model.*;

import java.util.List;

public interface DaoOtherTables {

    List<Department> getAllDepartments();

    List<Diagnosis> getAllDiagnosis();

    List<Jobs> getAllJobs();

    List<Medicine> getAllMedicines();

    List<Treatment> getAllTreatments();
}
