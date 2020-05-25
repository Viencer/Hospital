package com.test.service;

import com.test.dao.DaoOtherTables;
import com.test.model.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceOtherTablesImpl implements UserServiceOtherTables {
    private static Logger logger = Logger.getLogger(UserServiceOtherTablesImpl.class);

    private DaoOtherTables daoOtherTables;

    @Autowired
    public void setDaoOtherTables(DaoOtherTables daoOtherTables) {
        this.daoOtherTables = daoOtherTables;
    }

    @Override
    public List<Department> getAllDepartments() {
        logger.debug("called getAllDepartments() method. UserServiceImpl.class");
        return daoOtherTables.getAllDepartments();
    }

    @Override
    public List<Diagnosis> getAllDiagnosis() {
        logger.debug("called getAllDiagnosis() method. UserServiceImpl.class");
        return daoOtherTables.getAllDiagnosis();
    }

    @Override
    public List<Jobs> getAllJobs() {
        logger.debug("called getAllJobs() method. UserServiceImpl.class");
        return daoOtherTables.getAllJobs();
    }

    @Override
    public List<Medicine> getAllMedicines() {
        logger.debug("called getAllMedicines() method. UserServiceImpl.class");
        return daoOtherTables.getAllMedicines();
    }

    @Override
    public List<Treatment> getAllTreatments() {
        logger.debug("called getAllTreatments() method. UserServiceImpl.class");
        return daoOtherTables.getAllTreatments();
    }
}
