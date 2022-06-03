package org.repo.example.taco.models;

import lombok.*;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {
    private Long id;
    private String name;
    private Type type;


}


