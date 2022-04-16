package com.company.repository.impl;

import com.company.jdbc.DbConnection;
import com.company.model.Account;
import com.company.repository.AbstractRepository;
import com.company.repository.CrudRepository;
import com.company.service.AccountService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountRepository extends AbstractRepository implements CrudRepository<Account> {

    Statement statement;
    ResultSet rs;

    @Override
    public void save(Account account) throws SQLException {

        Connection con = DbConnection.getInstance();
        statement = con.createStatement();
        rs = null;
        if (con == null) {
            System.out.println("Connection is null");

        }
        assert con != null;
        System.out.println("Inserting records into the  account");
        String sql = "INSERT INTO account(sheba,account_number,balance,isactive,CUSTOMER_ID,ACCOUNT_ID)" +
                " VALUES ('" + account.getSheba() + "','" + account.getAccountNumber() + "','" + account.getBalance() + "'," + "'Y'" + ",'" + account.getCustomerId() + "', ACCOUNT_NUMBER_SEQ.NEXTVAL)";
        statement.executeUpdate(sql);
        System.out.println("-------------------------------------------------------------");
    }


    public void getAllAccount() {
    }

    public void showCustomerAccounts(int customerId) throws SQLException {
        statement = con.createStatement();
        rs = null;
        if (con == null) {
            System.out.println("conection is null");
        }
        assert con != null;
        String sql = "select * from account where CUSTOMER_ID = '" + customerId + "'";

        rs = statement.executeQuery(sql);
        int id = 0;
        System.out.println("id\t\t\t\taccount_number\t\t\t\t\tcustomerID\t\t\t\t\tsheba\t\t\t\t\t\t\tbalance");

        // Condiion check
        while (rs.next()) {

            id = rs.getInt("ACCOUNT_ID");
            String accountNumber = rs.getString("ACCOUNT_NUMBER");
            String customer_id = rs.getString("CUSTOMER_ID");
            String sheba = rs.getString("sheba");
            long balance = rs.getLong("balance");
            System.out.println(id + "\t\t" + accountNumber + "\t\t" + customer_id + "\t\t\t\t" + sheba + "\t\t\t\t" + balance);
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        }

    }

    @Override
    public String findAll() {
        return null;
    }

    @Override
    public Account find(String accountNumber) throws SQLException {

        statement = con.createStatement();
        rs = null;
        if (con == null) {
            System.out.println("conection is null");
        }
        assert con != null;
        String sql = "select * from account where ACCOUNT_NUMBER = '" + accountNumber + "'";

        rs = statement.executeQuery(sql);

        Account account = new Account();

        rs.next();
        account.setId(rs.getInt("ACCOUNT_ID"));
        account.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
        account.setCustomerId(Integer.parseInt(rs.getString("CUSTOMER_ID")));
        account.setSheba(rs.getString("sheba"));
        account.setBalance(rs.getLong("balance"));

        String isActive = rs.getString("ISACTIVE");
        if (isActive.equals("Y")){
        account.setActivity(true);}
        else { account.setActivity(false);}
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");


        return account;
    }


    public void updateBalanace(long balance , String accountNumber) throws SQLException {
        statement = con.createStatement();
        rs = null;
        if(con == null){
            System.out.println("connection is null");
        }
        String sql ="UPDATE ACCOUNT SET BALANCE = " + balance  + "where ACCOUNT_NUMBER  =" + accountNumber ;

        rs = statement.executeQuery(sql);
        rs.next();
    }

    public long getBalance(String accountNumber) throws SQLException {
        statement = con.createStatement();
        rs = null;
        if (con == null){
            System.out.println("connection is null");
        }

        String sql = "select balance from Account where ACCOUNT_NUMBER  = "+ accountNumber ;
        rs= statement.executeQuery(sql);
        rs.next();
        long balance = rs.getLong("balance");
        return balance;
    }
}
