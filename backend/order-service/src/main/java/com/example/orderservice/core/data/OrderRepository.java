package com.example.orderservice.core.data;

import com.example.orderservice.pojo.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {
    public OrderEntity findBy_id(String _id);
}
