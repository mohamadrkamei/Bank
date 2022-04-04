package com.company.controller.mobileBankController;

import com.company.dto.SimCardReChargeDto;
import com.company.service.MobileBankService;
import com.company.service.impl.MobileBankServiceImpl;

import java.sql.SQLException;

public class MobileBankController {


    MobileBankServiceImpl mobileBankService = new MobileBankServiceImpl() ;

    public void simCardRecharge(SimCardReChargeDto dto) throws SQLException {

        mobileBankService.simCardCharge(dto);

    }

}
