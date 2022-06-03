package org.repo.example.taco.repositories;

import org.repo.example.taco.entities.TacoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends CrudRepository<TacoEntity, Long> {
}
