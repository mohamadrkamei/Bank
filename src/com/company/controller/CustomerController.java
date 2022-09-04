package com.company.controller;


import com.company.service.impl.CustomerService;

import java.sql.SQLException;

public class CustomerController {

    CustomerService customerService = new CustomerService();
    public void createCustomer (String name , String nationalityId) throws SQLException {

        customerService.createCustomer( name ,  nationalityId);


    }

    public void showCustomers() throws SQLException {
        customerService.showCustomers();
    }

    public void findCustomer(String nationalityId) throws SQLException {
        customerService.findCustomer(nationalityId);
    }
}
