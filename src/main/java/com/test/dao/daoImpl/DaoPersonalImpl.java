package com.test.dao.daoImpl;

import com.test.dao.DaoConnection;
import com.test.dao.DaoPersonal;
import com.test.model.Personal;
import com.test.model.dbParse.personal.PersonalParse;
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
public class DaoPersonalImpl implements DaoPersonal {

    private static Logger logger = Logger.getLogger(DaoPersonalImpl.class);

    private DaoConnection daoConnection;

    @Autowired
    public void setDaoConnection(DaoConnection daoConnection) {
        this.daoConnection = daoConnection;
    }

    private PersonalParse personalParse;

    @Autowired
    public void setPersonalParse(PersonalParse personalParse) {
        this.personalParse = personalParse;
    }

    private Personal personal;
    private List<Personal> personals = new ArrayList<>();
    private ResultSet resultSet;
    private PreparedStatement statement;
    private String role;

    private void close() {
        try {
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            logger.error("error in close() ", e);
        }
    }

    @Override
    public List<Personal> selectAllPersonal() {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM LAB3MU_PERSONAL");
            resultSet = statement.executeQuery();
            personals = personalParse.getAllPersonal(resultSet);
            return personals;
        } catch (SQLException e) {
            logger.error("SQLException in selectAllPersonal() ", e);
        } finally {
            close();
        }
        return personals;
    }

    @Override
    public List<Personal> findByIdList(int id) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM LAB3MU_PERSONAL WHERE PERSONAL_ID = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            personals = personalParse.getAllPersonal(resultSet);
            return personals;
        } catch (SQLException e) {
            logger.error("SQLException in findByIdList() ", e);
        } finally {
            close();
        }
        return personals;
    }

    @Override
    public Personal findByIdPersonal(int id) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM LAB3MU_PERSONAL WHERE PERSONAL_ID = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            personal = personalParse.getPersonalBy(resultSet);
            return personal;
        } catch (SQLException e) {
            logger.error("SQLException in findByIdPersonal() ", e);
        } finally {
            close();
        }
        return personal;
    }

    @Override
    public Personal getByName(String name) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM LAB3MU_PERSONAL P, LAB3MU_USER_DATA R WHERE P.PERSONAL_ID = R.PERSONAL_ID AND USER_NAME = ?");
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            personal = personalParse.getPersonalBy(resultSet);
            return personal;
        } catch (SQLException e) {
            logger.error("SQLException in getByName() ", e);
        } finally {
            close();
        }
        return personal;
    }

    @Override
    public List<Personal> findByLastName(String lastName) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM LAB3MU_PERSONAL WHERE LAST_NAME = ?");
            statement.setString(1, lastName);
            resultSet = statement.executeQuery();
            personals = personalParse.getAllPersonal(resultSet);
            return personals;
        } catch (SQLException e) {
            logger.error("SQLException in findByLastName() ", e);
        } finally {
            close();
        }
        return personals;
    }

    @Override
    public void updatePersonal(int id, String lastName, int bossId, int com, int salary, int jobId, int department_id, Integer patient_id) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("UPDATE LAB3MU_PERSONAL" +
                    " SET LAST_NAME = ?, BOSS_ID = ?, PREMIUM = ?, SALARY = ?, JOB_ID = ?, DEPARTMENT_ID = ?, " +
                    "PATIENT_ID = ? WHERE PERSONAL_ID = ?");
            statement.setString(1, lastName);
            statement.setInt(2, bossId);
            statement.setInt(3, com);
            statement.setInt(4, salary);
            statement.setInt(5, jobId);
            statement.setInt(6, department_id);
            if (patient_id == 0) {
                statement.setNull(7, java.sql.Types.INTEGER);
            } else {
                statement.setInt(7, patient_id);
            }
            statement.setInt(8, id);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            logger.error("SQLException in update() ", e);
        } finally {
            close();
        }
    }

    @Override
    public void deletePersonal(int id) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("DELETE LAB3MU_PERSONAL WHERE PERSONAL_ID = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            logger.error("SQLException in deletePersonal() ", e);
        } finally {
            close();
        }
    }

    @Override
    public void createPersonal(String firstName, String lastName, int bossId, int premium, int salary, int jobId,
                               int department_id, Integer patient_id) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("INSERT INTO LAB3MU_PERSONAL " +
                    "(personal_id, first_name, last_name, boss_id, job_id, premium, salary, department_id, patient_id)  " +
                    "VALUES (LAB3MU_PERSONAL_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            if (bossId == 0) {
                statement.setNull(3, java.sql.Types.INTEGER);
            } else {
                statement.setInt(3, bossId);
            }
            statement.setInt(4, jobId);
            if (premium == 0) {
                statement.setNull(5, java.sql.Types.INTEGER);
            } else {
                statement.setInt(5, premium);
            }
            statement.setInt(6, salary);
            statement.setInt(7, department_id);
            if (patient_id == 0) {
                statement.setNull(8, java.sql.Types.INTEGER);
            } else {
                statement.setInt(8, patient_id);
            }
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            logger.error("SQLException in createPersonal() ", e);
        } finally {
            close();
        }
    }

    @Override
    public void createPersonalData(String username, String password, int jobId) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("INSERT INTO LAB3MU_USER_DATA " +
                    "(personal_id, user_name, password, role, enable) " +
                    "VALUES (LAB3MU_USER_DATA_SEQ.nextval, ?, ?, ?, 1)");
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, setRole(jobId));
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            logger.error("SQLException in createPersonalData() ", e);
        } finally {
            close();
        }
    }

    @Override
    public void updatePersonalData(int personalId, int jobId) {
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("UPDATE LAB3MU_USER_DATA" +
                    " SET ROLE = ? WHERE PERSONAL_ID = ?");
            statement.setString(1, setRole(jobId));
            statement.setInt(2, personalId);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            logger.error("SQLException in update() ", e);
        } finally {
            close();
        }
    }

    private String setRole(int jobId) {
        switch (jobId) {
            case 1:
                role = "ROLE_ADMIN";
                break;
            case 2:
                role = "ROLE_DOCTOR";
                break;
            case 3:
                role = "ROLE_INTERN";
                break;
        }
        return role;
    }
}
