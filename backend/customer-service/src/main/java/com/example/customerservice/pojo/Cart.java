package com.example.customerservice.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Cart implements Serializable {
    private String productId;
    private String color;
    private String size;
    private Integer quantity;
    private double price;
}
