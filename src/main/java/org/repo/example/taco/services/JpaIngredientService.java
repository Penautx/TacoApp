package org.repo.example.taco.services;

import org.repo.example.taco.mappers.IngredientMapper;
import org.repo.example.taco.models.Ingredient;
import org.repo.example.taco.repositories.IngredientRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class JpaIngredientService  implements IngredientService {

    private IngredientRepository ingredientRepository;
    public JpaIngredientService (IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }



    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll()
                .stream()
                .map(IngredientMapper::mapFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        return ingredientRepository.findById(Long.parseLong(id))
                .stream().map(IngredientMapper::mapFromEntity)
                .findFirst();
    }
}
