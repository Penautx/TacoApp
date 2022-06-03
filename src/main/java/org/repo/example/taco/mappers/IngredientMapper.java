package org.repo.example.taco.mappers;
import org.repo.example.taco.entities.IngredientEntity;
import org.repo.example.taco.models.Ingredient;

public class IngredientMapper {
     public static IngredientEntity mapToEntity (Ingredient ingredient){

         IngredientEntity ingredientEntity = new IngredientEntity();
         ingredientEntity.setName(ingredient.getName());
         ingredientEntity.setType(ingredient.getType());

         return ingredientEntity;
     }


     public static Ingredient mapFromEntity (IngredientEntity ingredientEntity) {
         return Ingredient.builder()
                 .id(ingredientEntity.getId())
                 .name(ingredientEntity.getName())
                 .type(ingredientEntity.getType())
                 .build();
     }

}
