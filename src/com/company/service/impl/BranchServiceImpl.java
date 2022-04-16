package com.company.service.impl;

import com.company.model.Transaction;
import com.company.service.AccountService;
import com.company.service.BranchService;
import com.company.service.TransactionService;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.sql.SQLException;

public class BranchServiceImpl implements BranchService {
   TransactionService transactionService = new TransactionServiceImpl();
   AccountService accountService = new AccountServiceImpl();
    @Override
    public void topUp(long amount, String accountNumber) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setCreditAccountNumber(accountNumber);
        transaction.setAmount(amount);
        transaction.setDescription("top Up Account ");
        transactionService.doTopUpTransaction(transaction);
    }

    @Override
    public void withdrawFromAccount(long amount, String accountNumber) throws Exception {
        accountService.withdrawal(amount,accountNumber);
    }

    @Override
    public void moneyTransfer(long amount,String debitAccountNumber, String creditAccountNumber) throws Exception {
       Transaction transaction = new Transaction();

       transaction.setDebitAccountNumber(debitAccountNumber);
       transaction.setCreditAccountNumber(creditAccountNumber);
       transaction.setAmount(amount);
       transaction.setDescription("money transfer(account to account)");

       transactionService.doTransaction(transaction);
    }
}
