package com.company.service;

import com.company.dto.TransactionDto;
import com.company.model.Transaction;

import java.sql.SQLException;

public interface TransactionService {

   void doTransaction(Transaction transaction) throws SQLException;

   void save(Transaction transaction) throws SQLException;

   void doTopUpTransaction(Transaction transaction) throws SQLException;
}
