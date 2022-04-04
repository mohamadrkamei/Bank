package com.company.service.impl;

import com.company.model.Transaction;
import com.company.repository.impl.TransactionRepository;
import com.company.service.TransactionService;

import java.sql.SQLException;

public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository =  new TransactionRepository();

    AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
    @Override
    public Transaction doTransaction(Transaction transaction) throws SQLException {

        try{
            accountServiceImpl.withdrawal(transaction.getAmount(),transaction.getDebitAccountNumber());
        transaction.setStatus(true);

        }catch (Exception e){
            transaction.setStatus(false);
        }

        transactionRepository.save(transaction);

        return null;
    }
}
