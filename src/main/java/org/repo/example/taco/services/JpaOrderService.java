package org.repo.example.taco.services;

import org.repo.example.taco.entities.IngredientEntity;
import org.repo.example.taco.entities.OrderEntity;
import org.repo.example.taco.mappers.OrderMapper;
import org.repo.example.taco.models.Order;
import org.repo.example.taco.models.Type;
import org.repo.example.taco.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class JpaOrderService implements OrderService{

    private final OrderRepository orderRepository;

    public JpaOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        final OrderEntity savedEntity = orderRepository.save(OrderMapper.mapToEntity(order));
        order.setId(savedEntity.getId());
        order.setPlacedAt(savedEntity.getPlacedAt());
        order.setTacos(savedEntity.getTacos());
        order.setName(savedEntity.getName());
        order.setCity(savedEntity.getCity());
        order.setCreditCardCVV(savedEntity.getCreditCardCVV());
        order.setCreditCardExpiration(savedEntity.getCreditCardExpiration());
        order.setCreditCardNumber(savedEntity.getCreditCardNumber());
        order.setStreet(savedEntity.getStreet());
        order.setZipCode(savedEntity.getZipCode());
        return order;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }


}
