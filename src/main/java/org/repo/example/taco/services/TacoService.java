package org.repo.example.taco.services;

import org.repo.example.taco.models.Taco;

import java.util.List;

public interface TacoService {

     Taco save (Taco taco);
     List<Taco> findAll();
}
