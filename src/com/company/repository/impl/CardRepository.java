package com.company.repository.impl;

import com.company.jdbc.DbConnection;
import com.company.model.CreaditCard;
import com.company.repository.AbstractRepository;
import com.company.repository.CrudRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CardRepository extends AbstractRepository implements CrudRepository<CreaditCard> {
    Statement statement;
    ResultSet rs;
    @Override
    public void save(CreaditCard creaditCard) throws SQLException {

        statement = con.createStatement();
        rs = null;
        if (con == null) {
            System.out.println("connection is null");
        }
        assert con != null;
        System.out.println("Inserting records in to the creaditCard");
        String sql = "INSERT INTO CARDS (CARD_NUMBER,EXPIRATION_DATE,CVV2,ACCOUNT_ID,CREADITCARD_ID)" + " VALUES ('" + creaditCard.getCardNumber() + "','" + creaditCard.getExpirationDate() + "','" + creaditCard.getCvv2() + "','" + creaditCard.getAccountId() + "', CARD_ID.NEXTVAL)";

        statement.executeUpdate(sql);
        System.out.println("-----------------------------------------------------------");
    }

    @Override
    public String findAll() {
        return null;
    }

    @Override
    public CreaditCard find(String cardNumber) throws SQLException {
        CreaditCard creaditCard = new CreaditCard();

            statement = con.createStatement();
            rs = null;
            if (con == null) {
                System.out.println("conection is null");
            }
            assert con != null;
            String sql = "select * from cards where CARD_NUMBER = '" + cardNumber + "'";

            rs = statement.executeQuery(sql);



           if(rs.next()) {
               creaditCard.setId(rs.getInt("CREADITCARD_ID"));
               creaditCard.setCvv2(rs.getString("CVV2"));
               creaditCard.setAccountId(Integer.parseInt(rs.getString("ACCOUNT_ID")));
               creaditCard.setCardNumber(rs.getString("CARD_NUMBER"));
               creaditCard.setExpirationDate(rs.getString("EXPIRATION_DATE"));


               System.out.println("id\t\tname\t\t\t\t\t\t\branchName\t\t\t\t\texpireDate");

               // Condiion check

               int id = rs.getInt("CREADITCARD_ID");
               String cVV2 = rs.getString("CVV2");
               String card_Number = rs.getString("CARD_NUMBER");
               String expireDate = rs.getString("EXPIRATION_DATE");
               System.out.println(id + "\t\t" + cVV2
                       + "\t\t\t\t" + card_Number + "\t\t\t\t" + expireDate);
           }
           else {

               System.out.println("کارتی با این مشخصات موجود نیست ");
           }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

            return creaditCard;

    }

    public String  findAccountNumberWithCard(String cardNumber) throws SQLException {
        statement = con.createStatement();
        rs = null;
        if (con == null) {
            System.out.println("conection is null");
        }
        assert con != null;
        String sql = "select account_number from ACCOUNT inner join cards ON  account.account_id = cards.account_id where cards.card_number='" +  cardNumber+"'";

        rs = statement.executeQuery(sql);
        rs.next();
        String accountNumber = rs.getString("ACCOUNT_NUMBER");

        return accountNumber;
    }
}

