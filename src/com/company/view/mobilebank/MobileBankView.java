package com.company.view.mobilebank;

import java.util.Scanner;

public class MobileBankView {



    public static  void  mainView(){
        Scanner scn = new Scanner(System.in);
        System.out.println("به موبایل بانک خوش آمدید ");
        System.out.println("1-خرید شارژ");
        System.out.println("2-انتقال کارت به کارت ");
        System.out.println("3-مشاهده ی موجودی");

        int choice = scn.nextInt();
        switch (choice){
            case 1: sIMcardrecharge();
            break;
            case 2:moneyTransfer();
            break;
            case 3: showBalance();
            break;
            case 0 : exist();
            break;
        }
    }

    private static void showBalance() {
    }

    private static void exist() {
    }

    private static void moneyTransfer() {
    }

    private static void sIMcardrecharge() {

        System.out.println("");
    }
}
