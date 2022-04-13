package com.company.view;

import com.company.controller.BranchController;

import java.sql.SQLException;
import java.util.Scanner;

public class BranchView {
    Scanner scn = new Scanner(System.in);
    boolean quit = false;
BranchController branchController =new BranchController();

    public  void view() throws Exception {
        do {

            System.out.println("1.شارژ حساب");
            System.out.println("2. انتقال حساب به حساب ");
            System.out.println("3. برداشت از حساب");
            System.out.println("0.صفحه ی قبل");


            int choice = scn.nextInt();

            switch (choice) {
                case 1:
                    topupAccount();
                    break;
                case 2:
                    moneyTransfer();
                    break;
                case 3:
                    withdrawFromAccount();
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

    private void withdrawFromAccount() throws Exception {
        System.out.println("شماره حساب خود را وارد کنید ");
        String AccountNumber = scn.next();
        System.out.println("مبلغ را وارد کنید  ");
        long amount = scn.nextInt();
        branchController.withdrawFromAccount(amount,AccountNumber);

    }

    private void moneyTransfer() throws Exception {
        System.out.println("شماره حساب خود را وارد کنید ");
        String debitAccountNumber = scn.next();

        System.out.println("شماره حساب مقصد را وارد کنید ");
        String creditAccountNumber = scn.next();

        System.out.println("مبلغ را وارد کنید  ");
        long amount = scn.nextInt();
        branchController.moneyTransfer(amount,debitAccountNumber,creditAccountNumber);
    }

    private void topupAccount() throws SQLException {

        System.out.println("شماره حساب خود را وارد کنید ");
        String accountNumber = scn.next();
        System.out.println("مبلغ شارژ حساب را وارد کنید  ");
        long amount = scn.nextInt();
        branchController.topupAccount(amount,accountNumber);



    }

}
