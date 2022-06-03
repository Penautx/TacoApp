package org.repo.example.taco;

import org.repo.example.taco.models.Ingredient;
import org.repo.example.taco.services.JpaIngredientService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private JpaIngredientService ingredientService;
    public IngredientByIdConverter (JpaIngredientService ingredientService){
        this.ingredientService = ingredientService;
    }



    @Override
    public Ingredient convert(String id) {
    return ingredientService.findById(id).orElseThrow();
    }
}
