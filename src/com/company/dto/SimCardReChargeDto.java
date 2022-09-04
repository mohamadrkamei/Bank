package com.company.dto;

import com.company.enumeration.Operator;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SimCardReChargeDto {

    long amount;
    String phoneNumber;
    String cardNumber;
    Operator operator;
}
