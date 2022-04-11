package com.company.service.impl;

import com.company.jdbc.DbConnection;
import com.company.model.Transaction;
import com.company.repository.impl.TransactionRepository;
import com.company.service.TransactionService;

import java.sql.SQLException;

public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository =  new TransactionRepository();

    AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
    @Override
    public void doTransaction(Transaction transaction) throws SQLException {
        char status;
        try{
            accountServiceImpl.withdrawal(transaction.getAmount(),transaction.getDebitAccountNumber());
        transaction.setStatus('y');
        System.out.println("تراکنش موفق");
        }catch (Exception e){
            transaction.setStatus('n');
            System.out.println("تراکنش نا موفق .موجودی کافی نیست ");

        }

      save(transaction);

    }

    @Override
    public void save(Transaction transaction) throws SQLException {
          try {

              transactionRepository.save(transaction);
          }catch (SQLException e){
             DbConnection.getInstance().rollback();

          }

    }
}
