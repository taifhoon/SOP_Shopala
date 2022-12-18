package com.example.orderservice.command.model;

import lombok.Data;

@Data
public class CreateOrderRestModel {
    private String productId;
    private String customerId;
    private String paymentId;
}
