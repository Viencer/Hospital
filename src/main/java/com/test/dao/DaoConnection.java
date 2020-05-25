package com.test.dao;

import javax.sql.DataSource;
import java.sql.Connection;

public interface DaoConnection {

    DataSource getDataSource();

    Connection getConnection();

    void connect();
}
