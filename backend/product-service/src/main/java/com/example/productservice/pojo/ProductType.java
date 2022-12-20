package com.example.productservice.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class ProductType implements Serializable {
    private BigDecimal price;
    private String color;
    private String size;
    private Integer quantity;
}
