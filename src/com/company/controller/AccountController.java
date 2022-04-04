package com.company.controller;

import com.company.service.impl.AccountServiceImpl;

import java.sql.SQLException;

public class AccountController {

    AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
    public void CreateAccount(int customerId) throws SQLException {

        accountServiceImpl.createAccount(customerId);

    }

    public void showCustomerAccounts(int customerId) throws SQLException {
        accountServiceImpl.showCustomerAccounts(customerId);

    }
}
