package org.repo.example.taco.services;
import lombok.extern.log4j.Log4j;
import org.repo.example.taco.entities.TacoEntity;
import org.repo.example.taco.mappers.IngredientMapper;
import org.repo.example.taco.mappers.TacoMapper;
import org.repo.example.taco.models.Ingredient;
import org.repo.example.taco.models.Taco;
import org.repo.example.taco.repositories.TacoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class JpaTacoService implements  TacoService {

    private final TacoRepository tacoRepository;

    public JpaTacoService(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }


    @Override
    public Taco save(Taco taco) {

        TacoEntity savedEntity = tacoRepository.save(TacoMapper.mapToEntity(taco));
        taco.setCreatedAt(savedEntity.getCreatedAt());
        taco.setIngredients(savedEntity
                .getIngredients().stream()
                .map(IngredientMapper::mapFromEntity)
                .collect(Collectors.toList()));
        taco.setName(savedEntity.getName());

        return taco;
    }

    @Override
    public List<Taco> findAll() {
        return null;
    }
}
