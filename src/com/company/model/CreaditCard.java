package com.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreaditCard {

    long accountId;
    long id;
    boolean accountStatus;
    String cardNumber;
    String expirationDate;
    String cvv2;

}
