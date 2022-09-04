package com.company.service;

import java.sql.SQLException;

public interface BranchService {

    void topUp(long amount,String accountNumber) throws SQLException;

    void withdrawFromAccount(long amount, String accountNumber) throws Exception;

    void moneyTransfer(long amount,String debitAccountNumber, String creditAccountNumber) throws Exception;
}
