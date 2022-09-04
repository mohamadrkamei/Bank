package com.company.model;

import com.company.enumeration.TransactionStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Transaction {


    int transactionId;
    String creditAccountNumber;
    String debitAccountNumber;
    long amount;
    String date;
    TransactionStatus status;
    String description;




}
