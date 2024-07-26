package com.rental.crm.controller;

import com.rental.crm.dto.Rental;
import com.rental.crm.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rental-controller")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService service;

    @PostMapping("/add")
    public Boolean persist(@RequestBody Rental rental){
        service.persist(rental);
        return true;
    }

    @GetMapping("/get-all")
    public List<Rental> retrieve(){
        return service.retrieve();
    }
}
