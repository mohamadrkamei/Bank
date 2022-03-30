package com.company.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SimCardReChargeDto {

    long amount;
    String phoneNumber;
    String cardNumber;
    String operator;
}
