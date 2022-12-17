package com.example.productservice.command.rest;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRestModel {

    private String name;
    private BigDecimal price;
    private String size;
    private String color;
    private Integer quantity;
}
