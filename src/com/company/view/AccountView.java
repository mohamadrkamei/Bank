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


    public  void view() throws SQLException, InterruptedException {
        do {

            System.out.println("1. ایجاد حساب جدید");
            System.out.println("2. مشاهده ی حساب های مشتری ");
            System.out.println("3. جست و جو در حساب ها ");
            System.out.println("0.صفحه ی قبل");


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
                    menuView.login();
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
        System.out.println("کد ملی مشتری را وارد کنید");
        String nationality = scn.next();
        int customerId=  customerService.findCustomer(nationality);
        System.out.println("---------------------------------------------------------------------------");
        if (customerId == 0 ){
            System.out.println("مشتری با این کد ملی وجود ندارد .");
        }else {

            accountController.showCustomerAccounts(customerId);
        }

    }

    private void createAccount() throws SQLException, InterruptedException {
        System.out.println("کد ملی مشتری را وارد کنید");
        String nationality = scn.next();
        int customerId=  customerService.findCustomer(nationality);
        System.out.println("---------------------------------------------------------------------------");
        Thread.sleep(5000);
        if (customerId > 0){

           accountController.CreateAccount(customerId);

       }
       else {

           System.out.println("مشتری با این مشخصات وجود ندارد . لطفا ابتدا مشتری را ایجاد کنید .");
           System.out.println("1-ایجاد مشتری ");
           System.out.println("2-کد ملی جدید ");
           System.out.println("3-صفحه ی قبل");
           int choice = scn.nextInt();
           switch (choice){
               case 1:
                   System.out.println("نام مشتری ");
                   String firstName = scn.next();
                   System.out.println("نام خانوادگی مشتری ");
                   String lastname = scn.next();
                   System.out.println("کد ملی");
                   String nationalityId = scn.next();
                   String fullName= firstName.concat(lastname);
                   customerService.createCustomer(fullName,nationalityId);
                   break;
               case 2: this.view();
               break;
               case 3:
                   menuView.login();
                   break;
           }
       }

    }

}
