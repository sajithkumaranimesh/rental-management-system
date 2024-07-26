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
import java.util.Optional;

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

    @Override
    public Rental retrieveById(Long id) {
        Optional<RentalEntity> rentalEntity = repository.findById(id);
        return new ModelMapper().map(rentalEntity, Rental.class);
    }

    @Override
    public void updateRental(Rental rental) {
        if(repository.findById(rental.getId()).isPresent()){
            repository.save(new ModelMapper().map(rental, RentalEntity.class));
        }
    }

    @Override
    public void deleteRentalById(Long id) {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
        }
    }
}
