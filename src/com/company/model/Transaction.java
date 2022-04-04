package com.company.model;

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
    boolean status;
    String description;




}
