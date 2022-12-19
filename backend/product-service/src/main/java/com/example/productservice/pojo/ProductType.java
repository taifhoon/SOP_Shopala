package com.example.productservice.pojo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductType {
    private BigDecimal price;
    private String color;
    private String size;
    private Integer quantity;
}
