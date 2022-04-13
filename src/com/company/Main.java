package com.company;

import com.company.jdbc.DbConnection;
import com.company.model.Bank;
import com.company.repository.impl.BankRepository;
import com.company.view.MenuView;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

        MenuView menuView = new MenuView();
        MenuView.login();


    }
}
