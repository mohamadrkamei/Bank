package com.company.controller;

import com.company.service.BranchService;
import com.company.service.impl.BranchServiceImpl;

import java.sql.SQLException;

public class BranchController {

    BranchService branchService = new BranchServiceImpl();
    public void topupAccount(long amount, String accountNumber) throws SQLException {
        branchService.topUp(amount,accountNumber);
    }

    public void withdrawFromAccount(long amount, String accountNumber) throws Exception {
        branchService.withdrawFromAccount( amount,accountNumber);
    }

    public void moneyTransfer(long amount , String debitAccountNumber, String creditAccountNumber) throws Exception {

        branchService.moneyTransfer(amount, debitAccountNumber,creditAccountNumber);

    }
}
