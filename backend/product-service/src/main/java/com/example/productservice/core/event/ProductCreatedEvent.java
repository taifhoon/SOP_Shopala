package com.example.productservice.core.event;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCreatedEvent {

    private String productId;
    private String name;
    private BigDecimal price;
    private String color;
    private String size;
    private Integer quantity;
}
