package com.company.view;

import com.company.controller.BankController;
import com.company.model.Bank;
import com.company.view.mobilebank.MobileBankView;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuView {

    public  static void login() throws Exception {
        Scanner scn = new Scanner(System.in);
        boolean quit = false;

            System.out.println("welcome ");

            System.out.println("1.new Bank");
            System.out.println("2.new customer ");
            System.out.println("3.new account ");
        System.out.println("4.creat card ");
        System.out.println("5.mobile bank ");
        System.out.println("6.branch ");

            System.out.println("0.exist");


            int choice = scn.nextInt();

            switch (choice) {
                case 1:
                    BankView bankView = new BankView();
                    bankView.view();
                    break;
                case 2:
                    CustomerView customerView = new CustomerView();
                    customerView.view();
                    break;
                case 3:
                    AccountView accountView = new AccountView();
                    accountView.view();
                    break;
                case 4:
                CreaditCardView creaditCardView = new CreaditCardView();
                creaditCardView.view();
                break;
                case 5:
                    MobileBankView mobileBankView = new MobileBankView();
                    mobileBankView.mainView();
                    break;
                case 6:
                     BranchView branchView= new BranchView();
                    branchView .view();
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("wrong choice.");

            }


    }




}
