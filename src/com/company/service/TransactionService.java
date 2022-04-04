package com.company.service;

import com.company.dto.TransactionDto;
import com.company.model.Transaction;

import java.sql.SQLException;

public interface TransactionService {

   Transaction doTransaction(Transaction transaction) throws SQLException;
}
