package org.repo.example.taco.controllers;


import lombok.extern.slf4j.Slf4j;
import org.repo.example.taco.models.Order;
import org.repo.example.taco.services.JpaOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping
@SessionAttributes("order")
public class OrderController {

    private JpaOrderService orderService;
    public OrderController (JpaOrderService orderService){

        this.orderService = orderService;
    }


    @GetMapping("/currentOrder")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping("/orders")
    public String processOrder(@Valid Order order, Errors errors,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors()){
            return "orderForm";
        }
        orderService.save(order);
        sessionStatus.setComplete();
        log.info("Zamówienie zostało złożone: " + order);
        return "redirect:/";
    }
}