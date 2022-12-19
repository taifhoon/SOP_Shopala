package com.example.orderservice.query.rest;

import lombok.Data;

import java.util.List;

@Data
public class OrderRestModel {
    private String _id;
    private List<String> productId;
    private String customerId;
    private String paymentId;
}
