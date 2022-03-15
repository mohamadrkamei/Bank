package com.company.model;

public class CreaditCard {

    Account account;
    boolean accountStatus;
    String cardNumber;
    String expirationDate;
    String cvv2;

    public Account getAccount() {
        return account;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }
}
