package com.company.service;

import java.sql.SQLException;

public interface AccountService {


    void withdrawal(long amount,String accountNumber) throws Exception;
    void deposit(long amount,String accountNumber) throws SQLException;
    void topup(long amount,String accountNumber) throws SQLException;

    long getBalance(String accountNumber) throws SQLException;
}
