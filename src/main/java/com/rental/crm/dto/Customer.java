package com.rental.crm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Customer {
    private Long id;
    private String name;
    private String city;
    private String phoneNumber;
}
