package org.repo.example.taco.entities;


import lombok.Data;
import org.repo.example.taco.models.Taco;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name="Taco_Order")
public class OrderEntity {

    @ManyToMany(targetEntity = TacoEntity.class)
    private List<Taco> tacos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date placedAt;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String creditCardNumber;
    private String creditCardExpiration;
    private String creditCardCVV;


}
