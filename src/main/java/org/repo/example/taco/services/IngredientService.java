package org.repo.example.taco.services;

import org.repo.example.taco.models.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientService {

    List<Ingredient> findAll();
    Optional<Ingredient> findById(String id);

}
