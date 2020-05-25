package com.test.service;

import com.test.dao.DaoPersonal;
import com.test.model.Personal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicePersonalImpl implements UserServicePersonal {
    private static Logger logger = Logger.getLogger(UserServicePersonalImpl.class);


    private DaoPersonal daoPersonal;

    @Autowired
    public void setDaoPersonal(DaoPersonal daoPersonal) {
        this.daoPersonal = daoPersonal;
    }

    @Override
    public List<Personal> allPersonal() {
        logger.debug("called allPersonal() method. UserServiceImpl.class");
        return daoPersonal.selectAllPersonal();
    }


    @Override
    public void createPersonal(String firstName, String lastName, int bossId, int premium, int salary, int jobId,
                               int department_id, Integer patient_id, String username, String password) {
        logger.debug("called createPersonal() method. UserServiceImpl.class");
        daoPersonal.createPersonal(firstName, lastName, bossId, premium, salary, jobId,
                department_id, patient_id);
        daoPersonal.createPersonalData(username, password, jobId);
    }

    @Override
    public void updatePersonal(int id, String lastName, int bossId, int premium, int salary, int jobId, int department_id, Integer patient_id) {
        logger.debug("called updatePersonal() method. UserServiceImpl.class");
        daoPersonal.updatePersonal(id, lastName, bossId, premium, salary, jobId, department_id, patient_id);
        daoPersonal.updatePersonalData(id, jobId);
    }


    @Override
    public void deletePersonal(int id) {
        logger.debug("called deletePersonal() method. UserServiceImpl.class");
        daoPersonal.deletePersonal(id);
    }

    @Override
    public List<Personal> getByIdPersonalList(int id) {
        logger.debug("called getByIdPersonalList() method. UserServiceImpl.class");
        return daoPersonal.findByIdList(id);
    }

    @Override
    public Personal getByIdPersonal(int id) {
        logger.debug("called getByIdPersonal() method. UserServiceImpl.class");
        return daoPersonal.findByIdPersonal(id);
    }

    @Override
    public Personal getByUserNamePersonal(String name) {
        logger.debug("called getByUserNamePersonal() method. UserServiceImpl.class");
        return daoPersonal.getByName(name);
    }

    @Override
    public List<Personal> findByLastName(String lastName) {
        logger.debug("called findByLastName() method. UserServiceImpl.class");
        return daoPersonal.findByLastName(lastName);
    }
}
