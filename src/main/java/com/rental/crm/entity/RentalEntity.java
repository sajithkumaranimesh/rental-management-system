package com.rental.crm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "rental")
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rentalDate;
    private String expectedReturnDate;
    private String dueDate;
    private String returnDate;
    private String fine;
    private String totalCost;
    private Long customerId;
    private List<Long> itemIds;
}
