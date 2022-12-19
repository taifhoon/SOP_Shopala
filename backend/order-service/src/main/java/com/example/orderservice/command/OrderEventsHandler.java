package com.example.orderservice.command;

import com.example.orderservice.command.model.DelOrderRestModel;
import com.example.orderservice.core.data.OrderRepository;
import com.example.orderservice.core.event.OrderCreatedEvent;
import com.example.orderservice.pojo.OrderEntity;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderEventsHandler {
    private final OrderRepository orderRepository;

    public OrderEventsHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @EventHandler
    public void on(OrderCreatedEvent event){
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(event, orderEntity);
        orderRepository.save(orderEntity);
    }

    @EventHandler
    public void on(DelOrderRestModel event){
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(event, orderEntity);
        orderRepository.delete(orderEntity);
    }
}
