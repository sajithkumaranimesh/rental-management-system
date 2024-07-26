package com.rental.crm.repository;

import com.rental.crm.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
    CustomerEntity findByName(String name);
}
