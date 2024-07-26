package com.rental.crm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Item {
    private Long id;
    private String name;
    private String rentalPerDay;
    private String finePerDay;
    private Boolean isAvailable;
}
