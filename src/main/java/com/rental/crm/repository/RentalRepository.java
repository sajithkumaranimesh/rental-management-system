package com.rental.crm.repository;

import com.rental.crm.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<RentalEntity,Long> {
}
