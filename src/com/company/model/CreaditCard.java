package com.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreaditCard {

    Account account;
    long id;
    boolean accountStatus;
    String cardNumber;
    String expirationDate;
    String cvv2;


}
