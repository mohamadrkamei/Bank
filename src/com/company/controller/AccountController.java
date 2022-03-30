package com.company.controller;

import com.company.service.impl.AccountService;

import java.sql.SQLException;

public class AccountController {

    AccountService accountService= new AccountService();
    public void CreateAccount(int customerId) throws SQLException {

        accountService.createAccount(customerId);

    }

    public void showCustomerAccounts(int customerId) throws SQLException {
        accountService.showCustomerAccounts(customerId);

    }
}
