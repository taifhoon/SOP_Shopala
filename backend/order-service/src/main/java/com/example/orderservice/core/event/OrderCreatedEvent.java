package com.example.orderservice.core.event;

import lombok.Data;

@Data
public class OrderCreatedEvent {
    private String _id;
    private String productId;
    private String customerId;
    private String paymentId;
}
