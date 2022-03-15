package com.company.repository.impl;

import com.company.jdbc.BankAppConnection;
import com.company.jdbc.DbConnection;
import com.company.model.Bank;


import java.sql.*;

public class BankRepository  {

    DbConnection connection =new DbConnection();
    Connection con = connect();
    Statement statement ;



    public Connection connect(){
        DbConnection.getInstance();
        return  connection.connect();
    }

    public void save(Bank bank) throws SQLException {


        Connection con = connect();
        statement = con.createStatement();
        ResultSet rs = null;
        if(con == null){
            System.out.println("conection is null");

        }
        assert con != null;
        System.out.println("Inserting records into the table...");
        String sql = "INSERT INTO banks(name,branchName,id) VALUES ('"+  bank.getName()+"','"+bank.getBranchName()+"', banks_seq.NEXTVAL)";
        statement.executeUpdate(sql);

    }

    public void showBanks() throws SQLException {
        System.out.println("load banks records ");
        String sql = "select * from banks";
        statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        System.out.println("id\t\tname\t\tbranchName");

        // Condiion check
        while (rs.next()) {

            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            String branchName = rs.getString("BRANCHNAME");
            System.out.println(id + "\t\t" + name
                   + "\t\t\t\t" + branchName);
        }

    }


}
