package com.rental.crm.controller;

import com.rental.crm.dto.Customer;
import com.rental.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customer-controller")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping("/add")
    public Boolean persist(@RequestBody Customer customer){
        service.persist(customer);
        return true;
    }

    @GetMapping("/get-all")
    public List<Customer> retrieve(){
        return service.retrieve();
    }

    @GetMapping("/get-by-id/{id}")
    public Customer retrieveById(@PathVariable Long id){
        return service.retrieveById(id);
    }

    @GetMapping("/get-by-name/{name}")
    public Customer retrieveByName(@PathVariable String name){
        return service.retrieveByName(name);
    }

    @PutMapping("/update")
    public Boolean updateCustomer(@RequestBody Customer customer){
        service.updateCustomer(customer);
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteCustomerById(@PathVariable Long id){
        service.deleteCustomer(id);
        return true;
    }
}
