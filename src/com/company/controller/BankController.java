package com.company.controller;

import com.company.model.Bank;
import com.company.repository.impl.BankRepository;

import java.sql.SQLException;

public class BankController {

    private BankRepository bankRepository = new BankRepository();

    public void createBank (Bank bank) throws SQLException {

        bankRepository.save(bank);
    }

    public void showBanks() throws SQLException {
        bankRepository.showBanks();

    }

}
