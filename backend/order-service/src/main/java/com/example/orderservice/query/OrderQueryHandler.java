package com.example.orderservice.query;

import com.example.orderservice.core.data.OrderRepository;
import com.example.orderservice.pojo.OrderEntity;
import com.example.orderservice.query.rest.OrderRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderQueryHandler {
    private final OrderRepository orderRepository;

    public OrderQueryHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @QueryHandler
    List<OrderRestModel> findProducts(FindOrderQuery query){
        List<OrderRestModel> ordersRest = new ArrayList<>();
        List<OrderEntity> storedOrders = orderRepository.findAll();
        for (OrderEntity orderEntity : storedOrders) {
            OrderRestModel orderRestModel = new OrderRestModel();
            BeanUtils.copyProperties(orderEntity, orderRestModel);
            ordersRest.add(orderRestModel);
        }
        return ordersRest;
    }
}
