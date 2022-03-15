package com.company.service;

import com.company.model.Customer;
import com.company.repository.impl.CustomerRepository;

import java.sql.SQLException;

public class CustomerService {

    Customer customer = new Customer();
    CustomerRepository customerRepository = new CustomerRepository();
    public void createCustomer (String name , String nationailtId) throws SQLException {
        customer.setName(name);
        customer.setNationalityId(nationailtId);
        customerRepository.save(customer);
    }

    public void showCustomers() throws SQLException {
        customerRepository.showCustomers();
    }

    public int findCustomer(String nationalityId) throws SQLException {
      return   customerRepository.findCustomer(nationalityId);

    }
}
