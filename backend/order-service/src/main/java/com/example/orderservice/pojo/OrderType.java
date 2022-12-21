package com.example.orderservice.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class OrderType implements Serializable {
    private String productId;
    private String color;
    private String size;
    private Integer quantity;
}
