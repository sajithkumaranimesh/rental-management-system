package com.rental.crm.service;

import com.rental.crm.dto.Rental;

import java.util.List;

public interface RentalService {
    void persist(Rental rental);

    List<Rental> retrieve();
}
