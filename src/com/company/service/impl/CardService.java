package com.company.service.impl;

import com.company.model.Account;
import com.company.model.CreaditCard;
import com.company.repository.impl.CardRepository;
import com.github.eloyzone.jalalicalendar.DateConverter;
import com.github.eloyzone.jalalicalendar.JalaliDate;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class CardService {

    CreaditCard creaditCard = new CreaditCard();

    AccountServiceImpl accountServiceImpl = new AccountServiceImpl();

    CardRepository cardRepository = new CardRepository();

    public void createCard(String accountNumber) throws SQLException {

        Account account = accountServiceImpl.findAccount(accountNumber);

        creaditCard.setCardNumber(generateCardNumber());
        creaditCard.setAccountId(account.getId());
        creaditCard.setAccountStatus(account.isActivity());
        creaditCard.setCvv2(generateCVV2());
        creaditCard.setExpirationDate(generateExpireDate());
        cardRepository.save(creaditCard);
    }

    public String generateCardNumber() {

        String part1 = "62198610";
        int min = 1000000;
        long max = 99999999;
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        String cardNumber = part1.concat(String.valueOf(random_int));
        return cardNumber;
    }

    public String generateCVV2() {

        String part1 = "62198610";
        int min = 1000;
        long max = 9999;
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        String CVV2 = String.valueOf(random_int);
        return CVV2;
    }

    public String generateExpireDate() {
        DateConverter dateConverter = new DateConverter();
        Calendar cal = Calendar.getInstance();
        LocalDate currentdate = LocalDate.now();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, 3); // to get previous year add -1
        int currentDay = currentdate.getDayOfMonth();
        System.out.println(currentDay);
        int currentMonth = currentdate.getMonthValue();
        System.out.println("Current month: " + currentMonth);
        //getting the current year
        int currentYear = currentdate.getYear() + 5;
        System.out.println("Current month: " + currentYear);

        JalaliDate jalaliDate = dateConverter.gregorianToJalali(currentYear, currentMonth, currentDay);
        System.out.println(jalaliDate);

        return String.valueOf(jalaliDate);
    }

    public void findCard(String cardNumber) throws SQLException {

        cardRepository.find(cardNumber);

    }


}
