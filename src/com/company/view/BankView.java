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
    public  void view() throws SQLException, InterruptedException {
        do {

            System.out.println("1. ایجاد بانک جدید");
            System.out.println("2. مشاهده ی لیست بانک ها ");
            System.out.println("0.صفحه ی قبل");


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
                    menuView.login();
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

        System.out.println("نام بانک  و شعبه را وارد کنید :");
        String name =  scn.next();
        String branchName =  scn.next();
        bank.setName(name);
        bank.setBranchName(branchName);

        bankController.createBank(bank);

    }

}
