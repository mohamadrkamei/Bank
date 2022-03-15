package com.company.repository.impl;

import com.company.jdbc.DbConnection;
import com.company.model.Bank;
import com.company.model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRepository {
    DbConnection connection =new DbConnection();
    Connection con = connect();
    Statement statement ;



    public Connection connect(){
        DbConnection.getInstance();
        return  connection.connect();
    }


    public void save(Customer customer) throws SQLException {


         con = connect();
        statement = con.createStatement();
        ResultSet rs = null;
        if(con == null){
            System.out.println("conection is null");

        }
        assert con != null;
        System.out.println("Inserting records into the customer table...");
        String sql = "INSERT INTO customer(name,NATIONALLITYID,CUSTOMER_ID) VALUES ('"+  customer.getName()+"','"+customer.getNationalityId()+"', customer_seq.NEXTVAL)";
        statement.executeUpdate(sql);

    }

    public int findCustomer(String nationalityId) throws SQLException {
        System.out.println("load coustomer records ");
        String sql = "select * from customer where NATIONALLITYID = '" + nationalityId +"'";
        statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        int id =0;
        System.out.println("id\t\tname\tnationalityId");

        // Condiion check
        while (rs.next()) {

             id = rs.getInt("CUSTOMER_ID");
            String name = rs.getString("NAME");
            String nationality = rs.getString("NATIONALLITYID");
            System.out.println(id + "\t\t" + name
                    + "\t\t\t\t" + nationality);
        }

        return id ;


    }

    public void showCustomers() throws SQLException {
        System.out.println("load customers records ");
        String sql = "select * from customer";
        statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        System.out.println("id\t\tname\t\tNATIONALLITYID");

        // Condiion check
        while (rs.next()) {

            int id = rs.getInt("customer_id");
            String name = rs.getString("NAME");
            String nationality = rs.getString("NATIONALLITYID");
            System.out.println(id + "\t\t" + name
                    + "\t\t\t\t" + nationality);
        }
    }


    }

