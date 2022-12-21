package com.example.orderservice.query.rest;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderRestModel implements Serializable {
    private String _id;
    private List<String> productId;
    private String customerId;
    private String paymentId;
}
