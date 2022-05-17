package org.repo.example.taco.models;

import lombok.Data;

@Data
public class Order {
    private String name;
    private String street;
    private String city;
    private String zipCode;
    private String creditCardNumber;
    private String creditCardExpiration;
    private String creditCardCVV;

}
