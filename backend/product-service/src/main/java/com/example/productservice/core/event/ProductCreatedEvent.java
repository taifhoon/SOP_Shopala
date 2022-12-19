package com.example.productservice.core.event;

import com.example.productservice.pojo.ProductType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductCreatedEvent {

    private String _id;
    private String name;
    private List<ProductType> type;
}
