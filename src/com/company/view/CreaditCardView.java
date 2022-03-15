package com.company.view;

import com.company.controller.AccountController;
import com.company.controller.CardController;
import com.company.service.CardService;
import com.company.service.CustomerService;

import java.sql.SQLException;
import java.util.Scanner;

public class CreaditCardView {

    Scanner scn = new Scanner(System.in);
    boolean quit = false;
    MenuView menuView = new MenuView();
    CustomerService customerService = new CustomerService();
    CardController cardController = new CardController();



    public  void view() throws SQLException, InterruptedException {
        do {

            System.out.println("1. ایجاد کارت");
            System.out.println("2. جست و جوی  کارت");
            System.out.println("0.صفحه ی قبل");


            int choice = scn.nextInt();

            switch (choice) {
                case 1:
                    createCard();
                    break;
                case 2:
                    findCard();
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

    private void createCard() throws SQLException {

        System.out.println("شماره حساب را وارد کنید");
        String accountNumber = scn.next();
     cardController.createCard(accountNumber);

    }

    private void findCard() throws SQLException {

        System.out.println("شماره کارت را وارد کنید");
        String cardNumber = scn.next();
        cardController.findcard(cardNumber);

    }


}
