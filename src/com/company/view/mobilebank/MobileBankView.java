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

    public  void  mainView() throws Exception {

        System.out.println("welcome to mobile Bank ");
        System.out.println("1-Buy a SIM card recharge ");
        System.out.println("2-money transfer with card to card ");
        System.out.println("3-show balance");

        int choice = scn.nextInt();
        switch (choice){
            case 1: simCardreCharge();
            MenuView.login();
            break;
            case 2:moneyTransferWithCard();
                MenuView.login();
            break;
            case 3: showBalance();
                MenuView.login();
            break;
            case 0 : exist();
            break;
        }
    }

    private void showBalance() throws SQLException {
        System.out.println("card Number : ");
        String cardNumber = scn.next();
      System.out.println(mobileBankController.getBalance(cardNumber));
    }

    private static void exist() throws Exception {
        MenuView.login();
    }

    private  void moneyTransferWithCard() throws Exception {
        System.out.println("card Number ");
        String debitCardNumber = scn.next();

        System.out.println("to card:  ");
        String creaditCardNumber = scn.next();

        System.out.println("amount : ");
        long amount = scn.nextInt();

        mobileBankController.moneyTransferWithCard(debitCardNumber,creaditCardNumber,amount);

    }

    private  void simCardreCharge() throws Exception {

        System.out.println("phone Number:");
        SimCardReChargeDto simCardReChargeDto = new SimCardReChargeDto();
        String phoneNumber= scn.next();

        System.out.println("recharge amount ? ");
        long chargeAmount= scn.nextInt();

        System.out.println("card Number ");
        String cardNumber= scn.next();
       Operator operator = useOperator();

        simCardReChargeDto.setPhoneNumber(phoneNumber);
        simCardReChargeDto.setAmount(chargeAmount);
        simCardReChargeDto.setCardNumber(cardNumber);
        simCardReChargeDto.setOperator(operator);

        mobileBankController.simCardRecharge(simCardReChargeDto);


    }

    private Operator useOperator() throws Exception {

        Operator operator = null;
        System.out.println("operator");

        System.out.println("1. mtn");
        System.out.println("2.mci ");
        System.out.println("3. rightell");
        System.out.println("0.previous");
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
