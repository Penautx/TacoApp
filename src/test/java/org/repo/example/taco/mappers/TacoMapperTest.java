package org.repo.example.taco.mappers;

import org.junit.jupiter.api.Test;
import org.repo.example.taco.entities.IngredientEntity;
import org.repo.example.taco.entities.TacoEntity;
import org.repo.example.taco.models.Ingredient;
import org.repo.example.taco.models.Taco;
import org.repo.example.taco.models.Type;
import org.repo.example.taco.services.JpaTacoService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TacoMapperTest {

    @Test
    public void isMapperConverterCorrectForTacoObject(){
        List<Ingredient> tacoIngredients = new ArrayList<Ingredient>(Arrays.asList(
                new Ingredient(5L, "cheddar", Type.CHEESE),
                new Ingredient(9L, "pikantny sos pomidorowy", Type.SAUCE),
                new Ingredient(6L, "sałata", Type.VEGGIES)
        ));
        Taco taco = new Taco();
        taco.initializeDate();
        taco.setIngredients(tacoIngredients);
        taco.setName("SimpleTaco");

        List<IngredientEntity> tacoIngredientsConverted = new ArrayList<IngredientEntity>(Arrays.asList(
                new IngredientEntity(5L, "cheddar", Type.CHEESE),
                new IngredientEntity(9L, "pikantny sos pomidorowy", Type.SAUCE),
                new IngredientEntity(6L, "sałata", Type.VEGGIES)
        ));
        TacoEntity tacoEntity = new TacoEntity();
        tacoEntity.setCreatedAt(taco.getCreatedAt());
        tacoEntity.setIngredients(tacoIngredientsConverted);
        tacoEntity.setName("SimpleTaco");
        TacoMapper tacoMapper = new TacoMapper();
        assertEquals(tacoEntity, tacoMapper.mapToEntity(taco));
    };
}