package com.company.controller;

import com.company.service.CardService;

import java.sql.SQLException;

public class CardController {

    CardService cardService = new CardService();

    public void createCard(String accountNumber) throws SQLException {
        cardService.createCard(accountNumber);
    }

    public void findcard(String cardNumber) throws SQLException {

        cardService.findCard(cardNumber);
    }
}
