package org.repo.example.taco.controllers;


import lombok.extern.slf4j.Slf4j;
import org.repo.example.taco.models.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping
public class OrderController {


    @GetMapping("/currentOrder")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping("/currentOrder")
    public String processOrder(@Valid Order order, Errors errors) {
        if (errors.hasErrors()){
            return "orderForm";
        }
        log.info("Zamówienie zostało złożone: " + order);
        return "redirect:/";
    }
}