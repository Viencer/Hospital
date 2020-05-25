package com.test.dao;

import com.test.model.Personal;

import java.util.List;

public interface DaoPersonal {

    List<Personal> selectAllPersonal();

    List<Personal> findByIdList(int id);

    Personal findByIdPersonal(int id);

    Personal getByName(String name);

    List<Personal> findByLastName(String lastName);

    void updatePersonal(int id, String lastName, int bossId, int exp, int salary, int jobId,
                        int department_id, Integer patient_id);

    void deletePersonal(int id);

    void createPersonal(String firstName, String lastName, int bossId, int exp, int salary, int jobId,
                        int department_id, Integer patient_id);

    void createPersonalData(String username, String password, int jobId);

    void updatePersonalData(int personalId, int jobId);

}
