package com.company.view;

import com.company.controller.CardController;
import com.company.service.impl.CustomerService;

import java.sql.SQLException;
import java.util.Scanner;

public class CreaditCardView {

    Scanner scn = new Scanner(System.in);
    boolean quit = false;
    MenuView menuView = new MenuView();
    CustomerService customerService = new CustomerService();
    CardController cardController = new CardController();



    public  void view() throws Exception {
        do {

            System.out.println("1. create card");
            System.out.println("2. find card");
            System.out.println("0.previous");


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

        System.out.println("account number : ");
        String accountNumber = scn.next();
     cardController.createCard(accountNumber);

    }

    private void findCard() throws SQLException {

        System.out.println("card Number");
        String cardNumber = scn.next();
        cardController.findcard(cardNumber);

    }


}
