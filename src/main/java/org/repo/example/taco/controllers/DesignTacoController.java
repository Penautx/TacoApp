package org.repo.example.taco.controllers;

import lombok.extern.slf4j.Slf4j;
import org.repo.example.taco.models.Ingredient;
import org.repo.example.taco.models.Taco;
import org.repo.example.taco.models.Type;
import org.repo.example.taco.services.JpaIngredientService;
import org.repo.example.taco.services.JpaTacoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequestMapping
public class DesignTacoController {

    private JpaIngredientService ingredientService;
    private JpaTacoService tacoService;

    public DesignTacoController(JpaIngredientService ingredientService, JpaTacoService tacoService) {
        this.ingredientService = ingredientService;
        this.tacoService = tacoService;
    }


    @GetMapping("/design")
    public Taco designForm(Taco design){
        return design;
    }

    @ModelAttribute(name = "design")
    public Taco design(Model model) {
        List<Ingredient> ingredients = ingredientService.findAll();

        EnumSet<Type> types = EnumSet.allOf(Type.class);
        log.info("List of types: " + types);
        log.info("Ingredients created: " + ingredients);

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    ingredients.stream()
                            .filter(ingredient -> ingredient.getType() == type)
                            .collect(Collectors.toList()));

        }
        return new Taco();
    }

    @PostMapping("/design")
    public String processDesign(@Valid Taco design, Errors errors) {
        log.info(errors.getAllErrors().toString());

        if (errors.hasErrors()){

            return "design";
        }
        design.initializeDate();
        Taco saved = tacoService.save(design);
        log.info("Taco has been created " + saved);

        return "redirect:/currentOrder";
    }
}
