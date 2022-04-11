package com.company.repository;

import com.company.jdbc.DbConnection;

import java.sql.Connection;
import java.sql.Statement;

public abstract class AbstractRepository {

    public DbConnection connection = new DbConnection();
    public Connection con = connect();

    public Connection connect() {
        DbConnection.getInstance();
        return connection.connect();

    }
}