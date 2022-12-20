package com.example.orderservice.command.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CreateOrderRestModel implements Serializable {
    private List<String> productId;
    private String customerId;
    private String paymentId;
}
