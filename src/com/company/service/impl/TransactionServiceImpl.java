package com.company.service.impl;

import com.company.enumeration.TransactionStatus;
import com.company.jdbc.DbConnection;
import com.company.model.Transaction;
import com.company.repository.impl.TransactionRepository;
import com.company.service.TransactionService;
import com.github.eloyzone.jalalicalendar.DateConverter;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository =  new TransactionRepository();

    AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
    @Override
    public void doTransaction(Transaction transaction) throws SQLException {
        transaction.setDate(getCurrentDate());
        try{
            accountServiceImpl.withdrawal(transaction.getAmount(),transaction.getDebitAccountNumber());
            accountServiceImpl.deposit(transaction.getAmount(),transaction.getCreditAccountNumber());
      transaction.setStatus(TransactionStatus.Successful);
        System.out.println("تراکنش موفق");
        }catch (Exception e){
            transaction.setStatus(TransactionStatus.Unsuccessful);
            System.out.println("تراکنش نا موفق .موجودی کافی نیست ");

        }

      save(transaction);

    }

    @Override
    public void doTopUpTransaction(Transaction transaction) throws SQLException {
        transaction.setDate(getCurrentDate());
        try{
            accountServiceImpl.topup(transaction.getAmount(),transaction.getCreditAccountNumber());
            transaction.setStatus(TransactionStatus.Successful);
            System.out.println("transaction is Successful");
        }catch (Exception e){
            transaction.setStatus(TransactionStatus.Unsuccessful);
            System.out.println("transaction is UnSuccessful  " + e);

        }

        save(transaction);

    }


    public String getCurrentDate() {
        DateConverter dateConverter = new DateConverter();
        Calendar cal = Calendar.getInstance();
        LocalDate currentdate = LocalDate.now();
        Date today = cal.getTime();
        System.out.println(today);

        return String.valueOf(today);
    }

    @Override
    public void save(Transaction transaction) throws SQLException {
          try {

              transactionRepository.save(transaction);
          }catch (SQLException e){
              System.out.println(e);
             DbConnection.getInstance().rollback();

          }

    }
}
