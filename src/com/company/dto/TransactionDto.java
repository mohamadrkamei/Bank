package com.company.dto;

import lombok.Data;

@Data
public class TransactionDto {

    String creditAccountNumber;
    String debitAccountNumber;
    long amount;
    String date;
    boolean status;
    String description;
}
