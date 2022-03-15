package com.company.service;

import com.company.model.Account;
import com.company.repository.impl.AccountRepository;

import java.sql.SQLException;


public class AccountService {

    Account account = new Account();
    String nationalCode = "IR";
    String contorllnumber = "06";
    String bankID = "001";
    AccountRepository accountRepository = new AccountRepository();
    public void createAccount(int customerId) throws SQLException {
        account.setCustomerId(customerId);
        account.setBalance(0);
        account.setActivity(true);
        account.setAccountNumber(generateAccountNumber());
        String sheba = nationalCode.concat(contorllnumber).concat(bankID).concat(account.getAccountNumber());
        account.setSheba(sheba);
       accountRepository.save(account);
    }

    public String generateAccountNumber(){
        long min = 100000000000l;
        long  max = 999999999999l;
        Long random_int = (long)Math.floor(Math.random()*(max-min+1)+min);
        String accountNumber = "000000" + random_int.toString();
        return  accountNumber;

    }

    public void showCustomerAccounts(int customerId) throws SQLException {
        accountRepository.showCustomerAccounts(customerId);
    }

    public Account findAccount(String accountNumber) throws SQLException {


        return accountRepository.find(accountNumber);
    }

}
