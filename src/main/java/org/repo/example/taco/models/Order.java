package org.repo.example.taco.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Order implements Serializable {

    private Long id;

    private Date placedAt;

    @NotBlank(message = "Podanie imienia jest obowiązkowe")
    private String name;

    @NotBlank(message = "Podanie ulicy jest obowiązkowe")
    private String street;

    @NotBlank(message = "Podanie miejscowości jest obowiązkowe")
    private String city;

    private String state;

    @NotBlank(message = "Podanie kodu pocztowego jest obowiązkowe")
    private String zipCode;

    @CreditCardNumber(message = "Nieprawidłowy numer karty kredytowej")
    private String creditCardNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
             message="Wartość musi być w formacie MM/RR.")
    private String creditCardExpiration;

    @Digits(integer = 3, fraction = 0, message = "Nieprawidłowy kod CVV")
    private String creditCardCVV;

    private List <Taco> tacos;

    public void addDesignToList(Taco design){

        this.tacos.add(design);
    }


}
