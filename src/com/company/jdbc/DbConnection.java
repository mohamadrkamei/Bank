package com.company.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection implements BankAppConnection {

    private static String url =  System.getenv("jdbc:oracle:thin@localhost:1521/xe") ;;

    private static String user =  System.getenv("rostami");

    private static String password =  System.getenv("rostami");

    private static Connection connect;


    public static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "rostami", "rostami");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }

    //connection to database ,when we want to connect to the database we can using this method

    @Override
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","rostami", "rostami");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

}
