package com.rental.crm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Rental {
    private Long id;
    private String rentalDate;
    private String expectedReturnDate;
    private String dueDate;
    private String returnDate;
    private String fine;
    private String totalCost;
    private Long customerId;
}
