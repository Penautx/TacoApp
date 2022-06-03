package org.repo.example.taco.services;

import org.junit.jupiter.api.Test;
import org.repo.example.taco.entities.IngredientEntity;
import org.repo.example.taco.models.Ingredient;
import org.repo.example.taco.models.Type;
import org.repo.example.taco.repositories.IngredientRepository;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.repo.example.taco.models.Type.WRAP;

class JpaIngredientServiceTest {

//    @Test
//    public void hasFoundAndMappedAllIngredients() {
//
//        List<IngredientEntity> ingredients = Arrays.asList(
//                new IngredientEntity("cos", "cos", Type.WRAP),
//                new IngredientEntity("Okej", "spróbujmy", Type.CHEESE),
//                new IngredientEntity("Okej", "spróbujmy",Type.CHEESE)
//        );
//
//        List<Ingredient> ingredientsafterMapping = Arrays.asList(
//                new Ingredient("cos", "cos", Type.WRAP),
//                new Ingredient("Okej", "spróbujmy", Type.CHEESE),
//                new Ingredient("Okej", "spróbujmy",Type.CHEESE)
//        );
//        assertEquals(ingredientsafterMapping, ingredients);
//    }



}