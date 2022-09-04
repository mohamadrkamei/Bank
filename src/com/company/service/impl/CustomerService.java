package com.company.service.impl;

import com.company.jdbc.DbConnection;
import com.company.model.Customer;
import com.company.repository.impl.CustomerRepository;

import java.sql.SQLException;

public class CustomerService {

    Customer customer = new Customer();
    CustomerRepository customerRepository = new CustomerRepository();

    public void createCustomer (String name , String nationailtId) throws SQLException {
        try {
            customer.setName(name);
            customer.setNationalityId(nationailtId);
            customerRepository.save(customer);
        }catch (Exception e){
            DbConnection.getInstance().rollback();
            System.out.println(e);
        }
        }

    public void showCustomers() throws SQLException {
        customerRepository.showCustomers();
    }

    public int findCustomer(String nationalityId) throws SQLException {
      return   customerRepository.findCustomer(nationalityId);

    }
}
