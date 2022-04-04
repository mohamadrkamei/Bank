package com.company.view.mobilebank;

import com.company.dto.SimCardReChargeDto;
import com.company.controller.mobileBankController.MobileBankController;
import com.company.enumeration.Operator;
import com.company.view.MenuView;

import java.sql.SQLException;
import java.util.Scanner;

public class MobileBankView {

     Scanner scn = new Scanner(System.in);
     MobileBankController mobileBankController = new MobileBankController();

    public  void  mainView() throws SQLException, InterruptedException {

        System.out.println("به موبایل بانک خوش آمدید ");
        System.out.println("1-خرید شارژ");
        System.out.println("2-انتقال کارت به کارت ");
        System.out.println("3-مشاهده ی موجودی");

        int choice = scn.nextInt();
        switch (choice){
            case 1: simCardreCharge();
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

    private  void simCardreCharge() throws SQLException, InterruptedException {

        System.out.println("شماره ی خود را وارد کنید ");
        SimCardReChargeDto simCardReChargeDto = new SimCardReChargeDto();
        String phoneNumber= scn.next();

        System.out.println("مبلغ شارژ را وارد کنید ");
        long chargeAmount= scn.nextInt();

        System.out.println("شماره کارت را وارد کنید ");
        String cardNumber= scn.next();
       Operator operator = useOperator();

        simCardReChargeDto.setPhoneNumber(phoneNumber);
        simCardReChargeDto.setAmount(chargeAmount);
        simCardReChargeDto.setCardNumber(cardNumber);
        simCardReChargeDto.setOperator(operator);

        mobileBankController.simCardRecharge(simCardReChargeDto);


    }

    private Operator useOperator() throws SQLException, InterruptedException {

        Operator operator = null;
        System.out.println("اپراتور خود را انتخاب کنید");

        System.out.println("1. ایرانسل");
        System.out.println("2. همراه اول ");
        System.out.println("3. رایتل ");
        System.out.println("0.صفحه ی قبل");
        int choice = scn.nextInt();

        switch (choice){
            case 1 :
                 operator = Operator.IRANCELL;
            break;
            case 2 : operator= Operator.MCI;
            break;
            case 3 : operator = Operator.RIGHTEL;
            break;
            case 0 :
                MenuView.login();
            default:
                System.out.println("wrong choice.");
                simCardreCharge();
        }

        return operator;
    }
}
