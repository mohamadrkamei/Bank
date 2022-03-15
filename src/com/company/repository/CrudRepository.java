package com.company.repository;

import com.company.model.Account;

import java.sql.SQLException;

public interface CrudRepository<T> {

    void save(T t) throws SQLException;
    String findAll();

    T find(String t) throws SQLException;
}
