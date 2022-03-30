package com.company.service;

import com.company.dto.TransactionDto;
import com.company.model.Transaction;

public interface TransactionService {

   Transaction doTransaction(TransactionDto transactionDto);
}
