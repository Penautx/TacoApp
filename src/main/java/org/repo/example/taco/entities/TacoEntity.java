package org.repo.example.taco.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.repo.example.taco.models.Ingredient;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco")
public class TacoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt;

    private String name;

    @ManyToMany(targetEntity=IngredientEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private List<IngredientEntity> ingredients;


}