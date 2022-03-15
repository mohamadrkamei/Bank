package com.company.repository.impl;

import com.company.model.CreaditCard;
import com.company.repository.AbstractRepository;
import com.company.repository.CrudRepository;
import com.company.service.CardService;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CardRepository extends AbstractRepository implements CrudRepository<CreaditCard> {
    Statement statement;
    ResultSet rs;

    @Override
    public void save(CreaditCard creaditCard) throws SQLException {
        con = connect();
        statement = con.createStatement();
        rs = null;
        if (con == null) {
            System.out.println("connection is null");
        }
        assert con != null;
        System.out.println("Inserting records in to the creaditCard");
        String sql = "INSERT INTO CARDS (CARD_NUMBER,EXPIRATION_DATE,CVV2,ACCOUNT_ID,CREADITCARD_ID)" +
                " VALUES ('" + creaditCard.getCardNumber() + "','" + creaditCard.getExpirationDate()
                + "','" + creaditCard.getCvv2() + "','" + creaditCard.getAccount().getId() + "', CARD_ID.NEXTVAL)";

        statement.executeUpdate(sql);
        System.out.println("-----------------------------------------------------------");
    }

    @Override
    public String findAll() {
        return null;
    }

    @Override
    public CreaditCard find(String t) throws SQLException {
        return null;
    }
}
