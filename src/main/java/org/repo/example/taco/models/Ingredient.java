package org.repo.example.taco.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class Ingredient {

    private String id;
    private String name;
    private Type type;


}
