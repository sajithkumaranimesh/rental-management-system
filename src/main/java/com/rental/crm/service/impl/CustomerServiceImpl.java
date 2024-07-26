package com.rental.crm.service.impl;

import com.rental.crm.dto.Customer;
import com.rental.crm.entity.CustomerEntity;
import com.rental.crm.repository.CustomerRepository;
import com.rental.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public void persist(Customer customer) {
        CustomerEntity customerEntity = new ModelMapper().map(customer, CustomerEntity.class);
        repository.save(customerEntity);
    }

    @Override
    public List<Customer> retrieve() {

        List<Customer> customerList = new ArrayList<>();

        List<CustomerEntity> customerEntityList = repository.findAll();
        customerEntityList.forEach(customerEntity -> {
            customerList.add(new ModelMapper().map(customerEntity, Customer.class));
        });

        return customerList;
    }

    @Override
    public Customer retrieveById(Long id) {
        Optional<CustomerEntity> customerEntity = repository.findById(id);
        return new ModelMapper().map(customerEntity,Customer.class);
    }

    @Override
    public Customer retrieveByName(String name) {
        CustomerEntity customerEntity = repository.findByName(name);
        return new ModelMapper().map(customerEntity, Customer.class);
    }

    @Override
    public void updateCustomer(Customer customer) {
        if(repository.findById(customer.getId()).isPresent()){
            repository.save(new ModelMapper().map(customer, CustomerEntity.class));
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
        }
    }


}
