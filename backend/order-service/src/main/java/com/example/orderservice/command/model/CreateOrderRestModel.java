package com.example.orderservice.command.model;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRestModel {
    private List<String> productId;
    private String customerId;
    private String paymentId;
}
