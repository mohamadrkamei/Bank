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

            System.out.println("1. ایجاد مشتری جدید");
            System.out.println("2. مشاهده ی تمام مشتریان ");
            System.out.println("3. جست و جو در مشتریان ");
            System.out.println("0.صفحه ی قبل");


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
       System.out.println("نام مشتری ");
       String firstName = scn.next();
        System.out.println("نام خانوادگی مشتری ");
        String lastname = scn.next();
       System.out.println("کد ملی");
       String nationalityId = scn.next();
       String fullName= firstName.concat(lastname);
       customerController.createCustomer(fullName,nationalityId);

    }
    private void findCustomer() throws SQLException {
        System.out.println("کد ملی مشتری مورد نظر را وارد کنید :");
        String nationalityId = scn.next();

        customerController.findCustomer(nationalityId);
    }


}
