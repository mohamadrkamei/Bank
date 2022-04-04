package com.company.repository.impl;

import com.company.model.Transaction;
import com.company.repository.AbstractRepository;
import com.company.repository.CrudRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionRepository  extends AbstractRepository implements CrudRepository<Transaction> {

    Statement statement;
    ResultSet rs;



    @Override
    public void save(Transaction transaction) throws SQLException {
        statement = con.createStatement();
        rs = null;
        if (con ==  null){
            System.out.println("Connection is nulle");
        }
        System.out.println("Inserting records into the  account");

        String sql = "INSERT INTO transaction(CREDIT_ACCOUNT_NUMBER , DEBIT_ACCOUNT_NUMBER, AMOUNT , DATE, DESCRIPTION ,STATUS,ID)" +
                "VALUES('" + transaction.getCreditAccountNumber() +
                "','" + transaction.getDebitAccountNumber() +
                "','" + transaction.getAmount() +
                "','"+transaction.getDate() +
                "','" + transaction.getDescription() +
                "','"+ transaction.isStatus()+ "', TRANSACTION_ID.NEXTVAL)";
        rs = statement.executeQuery(sql);
        rs.next();
        System.out.println("-------------------------------------------------------------");
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
