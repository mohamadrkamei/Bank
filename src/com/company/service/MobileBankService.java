package com.company.service;

import com.company.dto.SimCardReChargeDto;

import java.sql.SQLException;

public interface MobileBankService {


    void simCardCharge(SimCardReChargeDto simCardReChargeDto) throws SQLException;
}
