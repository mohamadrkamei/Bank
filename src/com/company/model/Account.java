package com.company.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Account {

    long id;
    String accountNumber;
    String sheba;
    boolean activity;
    int customerId;
    long balance;


}
