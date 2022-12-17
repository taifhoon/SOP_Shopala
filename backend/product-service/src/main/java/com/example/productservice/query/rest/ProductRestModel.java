package com.example.productservice.query.rest;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRestModel {

    private String _id;
    private String name;
    private BigDecimal price;
    private String color;
    private String size;
    private Integer quantity;
}
