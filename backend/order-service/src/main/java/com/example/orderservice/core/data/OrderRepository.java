package com.example.orderservice.core.data;

import com.example.orderservice.pojo.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {

    @Query(value = "{ _id : '?0' }")
    public OrderEntity findBy_id(String _id);
}
