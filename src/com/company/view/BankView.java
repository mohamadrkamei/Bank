package com.company.view;

import com.company.controller.BankController;
import com.company.model.Bank;

import java.sql.SQLException;
import java.util.Scanner;

public class BankView {
    BankController bankController =new BankController();
    Scanner scn = new Scanner(System.in);
    boolean quit = false;
    MenuView menuView = new MenuView();
    public  void view() throws Exception {
        do {

            System.out.println("1. create bank");
            System.out.println("2.list of bank ");
            System.out.println("0.Previous");


            int choice = scn.nextInt();

            switch (choice) {
                case 1:
                    createBank();
                    break;
                case 2:
                    showBanks();
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


    private void showBanks() throws SQLException {

        bankController.showBanks();
    }

    private void createBank() throws SQLException {
        Bank bank = new Bank();
        System.out.println();

        System.out.println("bank name and branch name :");
        String name =  scn.next();
        String branchName =  scn.next();
        bank.setName(name);
        bank.setBranchName(branchName);

        bankController.createBank(bank);

    }

}
