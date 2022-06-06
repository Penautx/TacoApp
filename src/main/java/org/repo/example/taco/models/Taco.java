package org.repo.example.taco.models;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
public class Taco {

    private Date createdAt;

    @NotNull
    @Size(min=5, message="Nazwa musi składać się z przynajmniej pięciu znaków")
    private String name;

    @Size(min=1, message="Musisz wybrać conajmniej jeden składnik")
    private List<Ingredient> ingredients;

    public void initializeDate(){
        this.createdAt = new Date();
    }

    public void addIngredientToList(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }


}
