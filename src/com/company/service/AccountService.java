package com.company.service;

import java.sql.SQLException;

public interface AccountService {


    void withdrawal(long amount,String accountNumber) throws SQLException;
    void deposit(long amount,String accountNumber) throws SQLException;
    String findAccountNumberWithCard(String cardNumber);

}
