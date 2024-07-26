package com.rental.crm.repository;

import com.rental.crm.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositoty extends JpaRepository<ItemEntity,Long> {
    ItemEntity findByName(String name);
}
