package com.rental.crm.service;

import com.rental.crm.dto.Customer;

import java.util.List;

public interface CustomerService {
    void persist(Customer customer);

    List<Customer> retrieve();

    Customer retrieveById(Long id);

    Customer retrieveByName(String name);

    void updateCustomer(Customer customer);

    void deleteCustomer(Long id);
}
