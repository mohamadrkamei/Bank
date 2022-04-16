package com.company.view;

import com.company.controller.BankController;
import com.company.controller.CustomerController;
import com.company.model.Bank;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerView {

    CustomerController customerController =new CustomerController();
    Scanner scn = new Scanner(System.in);
    boolean quit = false;
    MenuView menuView = new MenuView();
    public  void view() throws Exception {
        do {

            System.out.println("1. add new customer");
            System.out.println("2. show all of customer");
            System.out.println("3.find customer");
            System.out.println("0.Previous");


            int choice = scn.nextInt();

            switch (choice) {
                case 1:
                    createCustomer();
                    break;
                case 2:
                    showCustomers();
                    break;
                case 3:
                    findCustomer();
                    break;
                case 0:
                    quit = true;
                    MenuView.login();
                    break;
                default:
                    System.out.println("wrong choice.");

            }
        } while (!quit);

        System.out.println("thanks");

    }


    private void showCustomers() throws SQLException {
        customerController.showCustomers();
    }

    private void createCustomer() throws SQLException {
       System.out.println("first Name  ");
       String firstName = scn.next();
        System.out.println("last name:  ");
        String lastname = scn.next();
       System.out.println("national ID");
       String nationalityId = scn.next();
       String fullName= firstName.concat(lastname);
       customerController.createCustomer(fullName,nationalityId);

    }
    private void findCustomer() throws SQLException {
        System.out.println("national ID  :");
        String nationalityId = scn.next();

        customerController.findCustomer(nationalityId);
    }


}
