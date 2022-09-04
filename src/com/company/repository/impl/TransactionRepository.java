package com.company.repository.impl;

import com.company.jdbc.DbConnection;
import com.company.model.Transaction;
import com.company.repository.AbstractRepository;
import com.company.repository.CrudRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionRepository extends AbstractRepository implements CrudRepository<Transaction> {

    Statement statement;
    ResultSet rs;


    @Override
    public void save(Transaction transaction) throws SQLException {
       Connection con = DbConnection.getInstance();
        statement = con.createStatement();
        rs = null;

        if (con == null) {
            System.out.println("Connection is null");
        }

            String sql = "INSERT INTO ACCOUNT_TRANSACTION(CREADIT_ACCOUNT_NUMBER, DEBIT_ACCOUNT_NUMBER, AMOUNT , TRANSACTION_DATE, DESCRIPTION ,STATUS,TRANSACTION_ID)" +
                    "VALUES('" + transaction.getCreditAccountNumber() +
                    "','" + transaction.getDebitAccountNumber() +
                    "','" + transaction.getAmount() +
                    "','" + transaction.getDate() +
                    "','" + transaction.getDescription() +
                    "','" + transaction.getStatus() + "',  transaction_seq.nextval)";
            rs = statement.executeQuery(sql);
            rs.next();
            System.out.println("-------------------------------------------------------------");
            System.out.println("insert transaction to database");

    }

    @Override
    public String findAll() {
        return null;
    }

    @Override
    public Transaction find(String t) throws SQLException {
        return null;
    }

}
