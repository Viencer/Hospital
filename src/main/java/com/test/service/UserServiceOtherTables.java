package com.test.service;

import com.test.model.*;

import java.util.List;

public interface UserServiceOtherTables {

    List<Department> getAllDepartments();

    List<Diagnosis> getAllDiagnosis();

    List<Jobs> getAllJobs();

    List<Medicine> getAllMedicines();

    List<Treatment> getAllTreatments();
}
