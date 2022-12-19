package com.example.orderservice.core.event;

import lombok.Data;

import java.util.List;

@Data
public class OrderCreatedEvent {
    private String _id;
    private List<String> productId;
    private String customerId;
    private String paymentId;
}
