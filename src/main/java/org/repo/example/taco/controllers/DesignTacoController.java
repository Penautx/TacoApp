package org.repo.example.taco.controllers;

import lombok.extern.slf4j.Slf4j;
import org.repo.example.taco.models.Ingredient;
import org.repo.example.taco.models.Order;
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
@RequestMapping("/design")
public class DesignTacoController {

    private JpaIngredientService ingredientService;
    private JpaTacoService tacoService;
    public DesignTacoController(JpaIngredientService ingredientService, JpaTacoService tacoService){
        this.ingredientService = ingredientService;
        this.tacoService = tacoService;
    }

    @GetMapping
    public String showDesignForm(Model model) {
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
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@ModelAttribute Taco design, Model model){
        Order order = new Order();
        design.initializeDate();
        Taco saved = tacoService.save(design);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }
}
