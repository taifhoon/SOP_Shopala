package com.example.productservice.command.model;

import com.example.productservice.pojo.ProductType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateProductRestModel {

    private String name;
    private List<ProductType> type;
}
