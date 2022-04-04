package com.company.service.impl;

import com.company.dto.SimCardReChargeDto;
import com.company.dto.TransactionDto;
import com.company.enumeration.Operator;
import com.company.model.Transaction;
import com.company.service.AccountService;
import com.company.service.MobileBankService;
import com.company.service.TransactionService;
import com.github.eloyzone.jalalicalendar.DateConverter;
import com.github.eloyzone.jalalicalendar.JalaliDate;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class MobileBankServiceImpl implements MobileBankService {

    TransactionService transactionService = new TransactionServiceImpl();
    AccountServiceImpl accountService = new AccountServiceImpl();
    @Override
    public void simCardCharge(SimCardReChargeDto simCardReChargeDto) throws SQLException {

        Transaction transaction = new Transaction();

        transaction.setAmount(simCardReChargeDto.getAmount());
        transaction.setCreditAccountNumber(simCardReChargeDto.getCardNumber());
        transaction.setDescription("خرید شارژ موبایل");
        transaction.setDate(getCurrentDate());
        if(simCardReChargeDto.getOperator() == Operator.MCI){
        transaction.setCreditAccountNumber("000000812218758817");
        }
        if(simCardReChargeDto.getOperator() == Operator.IRANCELL){
            transaction.setCreditAccountNumber("000000812218758817");
        }
        if(simCardReChargeDto.getOperator() == Operator.RIGHTEL){
            transaction.setCreditAccountNumber("000000812218758817");
        }

        transactionService.doTransaction(transaction);
    }

    public String getCurrentDate() {
        DateConverter dateConverter = new DateConverter();
        Calendar cal = Calendar.getInstance();
        LocalDate currentdate = LocalDate.now();
        Date today = cal.getTime();
        System.out.println(today);

        return String.valueOf(today);
    }
}
