package com.company.controller.mobileBankController;

import com.company.dto.SimCardReChargeDto;
import com.company.service.MobileBankService;
import com.company.service.impl.MobileBankServiceImpl;

import java.sql.SQLException;

public class MobileBankController {


    MobileBankServiceImpl mobileBankService = new MobileBankServiceImpl() ;

    public void simCardRecharge(SimCardReChargeDto dto) throws SQLException {

        mobileBankService.simCardCharge(dto);

    }

    public void moneyTransferWithCard(String debitCardNumber, String creditCardNumber, long amount) throws Exception {

        mobileBankService.moneyTransferWithCard(debitCardNumber,creditCardNumber,amount);
    }

    public Long getBalance(String cardNumber) throws SQLException {
       return mobileBankService.getBalance(cardNumber);
    }
}
