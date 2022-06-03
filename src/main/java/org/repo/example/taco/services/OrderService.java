package org.repo.example.taco.services;

import org.repo.example.taco.models.Order;

import java.util.List;

public interface OrderService {
    Order save (Order order);
    List<Order> findAll();
}
