package com.rental.crm.service.impl;

import com.rental.crm.dto.Rental;
import com.rental.crm.entity.RentalEntity;
import com.rental.crm.repository.RentalRepository;
import com.rental.crm.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository repository;

    @Override
    public void persist(Rental rental) {
        RentalEntity rentalEntity = new ModelMapper().map(rental, RentalEntity.class);
        repository.save(rentalEntity);
    }

    @Override
    public List<Rental> retrieve() {

        List<Rental> rentalList = new ArrayList<>();

        for (RentalEntity rentalEntity : repository.findAll()) {
            rentalList.add(new ModelMapper().map(rentalEntity, Rental.class));
        }
        return rentalList;
    }
}
