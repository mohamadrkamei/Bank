package com.company.service.impl;

import com.company.model.Account;
import com.company.repository.impl.AccountRepository;
import com.company.service.AccountService;

import java.sql.SQLException;


public class AccountServiceImpl implements AccountService {

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

    @Override
    public void withdrawal(long amount, String accountNumber) throws Exception {
          Account account = findAccount(accountNumber);
          if (account.getBalance()<amount){
              throw  new Exception("account balance error");
          }else {
              long balance = account.getBalance() - amount;
              accountRepository.updateBalanace(balance, accountNumber);
          }
    }

    @Override
    public void deposit(long amount, String accountNumber) throws SQLException {
        Account account = findAccount(accountNumber);
        long balance =account.getBalance() - amount;
        account.setBalance(balance);
        accountRepository.updateBalanace( balance, accountNumber);
    }

    @Override
    public void topup(long amount, String accountNumber) throws SQLException {
        Account account = findAccount(accountNumber);
        long balance =account.getBalance() + amount;
        account.setBalance(balance);
        accountRepository.updateBalanace( balance, accountNumber);
    }

    @Override
    public long getBalance(String accountNumber) throws SQLException {
        return accountRepository.getBalance(accountNumber);
    }


}
