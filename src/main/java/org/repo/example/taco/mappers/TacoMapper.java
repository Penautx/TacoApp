package org.repo.example.taco.mappers;
import org.repo.example.taco.entities.IngredientEntity;
import org.repo.example.taco.entities.TacoEntity;
import org.repo.example.taco.models.Ingredient;
import org.repo.example.taco.models.Taco;
import java.util.List;
import java.util.stream.Collectors;


public class TacoMapper {

    public static TacoEntity mapToEntity (Taco taco){

        TacoEntity mappedEntity = new TacoEntity();
        mappedEntity.setCreatedAt(taco.getCreatedAt());
        mappedEntity.setName(taco.getName());
        mappedEntity.setIngredients(taco.getIngredients().stream().map(IngredientMapper::mapToEntity).collect(Collectors.toList()));
        return mappedEntity;
    }


    public static Taco mapFromEntity (TacoEntity tacoEntity) {
        Taco taco = new Taco();
        taco.setName(tacoEntity.getName());
        taco.setIngredients((List< Ingredient >) (List) tacoEntity.getIngredients());
        taco.setCreatedAt(tacoEntity.getCreatedAt());
        return taco;

    }


}
