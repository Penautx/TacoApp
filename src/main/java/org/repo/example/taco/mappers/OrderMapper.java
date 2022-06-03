package org.repo.example.taco.mappers;

import org.repo.example.taco.entities.OrderEntity;
import org.repo.example.taco.models.Order;

public class OrderMapper {
    public static OrderEntity mapToEntity (Order order) {

        OrderEntity mappedEntity = new OrderEntity();
        mappedEntity.setCity(order.getCity());
        mappedEntity.setName(order.getName());
        mappedEntity.setCreditCardCVV(order.getCreditCardCVV());
        mappedEntity.setCreditCardExpiration(order.getCreditCardExpiration());
        mappedEntity.setCreditCardNumber(order.getCreditCardNumber());
        mappedEntity.setPlacedAt(order.getPlacedAt());
        mappedEntity.setState(order.getState());
        mappedEntity.setTacos(order.getTacos());
        mappedEntity.setZipCode(order.getZipCode());
        mappedEntity.setStreet(order.getStreet());

    return mappedEntity;
    }

    public static Order mapFromEntity (OrderEntity orderEntity) {
        Order order = new Order();
                order.setId(orderEntity.getId());
                order.setCity(orderEntity.getCity());
                order.setStreet(orderEntity.getStreet());
                order.setName(orderEntity.getName());
                order.setState(orderEntity.getState());
                order.setCreditCardExpiration(orderEntity.getCreditCardExpiration());
                order.setCreditCardCVV(orderEntity.getCreditCardCVV());
                order.setCreditCardNumber(orderEntity.getCreditCardNumber());
                order.setPlacedAt(orderEntity.getPlacedAt());
                order.setTacos(orderEntity.getTacos());
                return order;
    }
}
