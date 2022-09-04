package com.company.view;

import com.company.controller.AccountController;
import com.company.service.impl.CustomerService;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountView {

    Scanner scn = new Scanner(System.in);
    boolean quit = false;
    MenuView menuView = new MenuView();
    CustomerService customerService = new CustomerService();
    AccountController accountController = new AccountController();


    public  void view() throws Exception {
        do {

            System.out.println("1. create account ");
            System.out.println("2.show customers account ");
            System.out.println("3. find account ");
            System.out.println("0.Previous");


            int choice = scn.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    showCustomerAccounts();
                    break;
                case 3:
                    findAccount();
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

    private void findAccount() {
    }

    private void showCustomerAccounts() throws SQLException {
        System.out.println("customers national ID : ");
        String nationality = scn.next();
        int customerId=  customerService.findCustomer(nationality);
        System.out.println("---------------------------------------------------------------------------");
        if (customerId == 0 ){
            System.out.println("National ID not found  .");
        }else {

            accountController.showCustomerAccounts(customerId);
        }

    }

    private void createAccount() throws Exception {
        System.out.println("customers national ID :");
        String nationality = scn.next();
        int customerId=  customerService.findCustomer(nationality);
        System.out.println("---------------------------------------------------------------------------");
        Thread.sleep(5000);
        if (customerId > 0){

           accountController.CreateAccount(customerId);

       }
       else {

           System.out.println("Customer not found with this profile . create customer .");
           System.out.println("1-create customer ");
           System.out.println("2-national ID ");
           System.out.println("3-previous");
           int choice = scn.nextInt();
           switch (choice){
               case 1:
                   System.out.println("customer first name  ");
                   String firstName = scn.next();
                   System.out.println("customer last Name  ");
                   String lastname = scn.next();
                   System.out.println("national ID");
                   String nationalityId = scn.next();
                   String fullName= firstName.concat(lastname);
                   customerService.createCustomer(fullName,nationalityId);
                   break;
               case 2: this.view();
               break;
               case 3:
                   MenuView.login();
                   break;
           }
       }

    }

}
