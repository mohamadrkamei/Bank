package com.company.service;

import com.company.dto.SimCardReChargeDto;

import java.sql.SQLException;

public interface MobileBankService {


    void simCardCharge(SimCardReChargeDto simCardReChargeDto) throws SQLException;
     void moneyTransferWithCard(String debitCardNumber, String creaditCardNumber, long amount) throws Exception;

    long getBalance(String cardNumber) throws SQLException;
}
