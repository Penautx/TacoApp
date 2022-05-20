package org.repo.example.taco.controllers;

import lombok.extern.slf4j.Slf4j;
import org.repo.example.taco.models.Ingredient;
import org.repo.example.taco.models.Taco;
import org.repo.example.taco.models.Type;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "pszenna", Type.WRAP),
                new Ingredient("COTO", "kukurydziana", Type.WRAP),
                new Ingredient("GRBF", "mielona wołowina", Type.PROTEIN),
                new Ingredient("CARN", "kawałki mięsa", Type.PROTEIN),
                new Ingredient("TMTO", "pomidory pokrojone w kostkę", Type.VEGGIES),
                new Ingredient("LETC", "sałata", Type.VEGGIES),
                new Ingredient("CHED", "cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterey Jack", Type.CHEESE),
                new Ingredient("SLSA", "pikantny sos pomidorowy", Type.SAUCE)
        );

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

//    @PostMapping
//    public String processDesign(@Valid Taco design, Errors errors){
//        if (errors.hasErrors()) {
//           return "design";
//        }
//        log.info("Przetwarzanie projektu taco: " + design);
//        return "redirect:/orders/current";
//    }
}
