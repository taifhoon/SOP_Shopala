package com.example.productservice.command.model;

import com.example.productservice.pojo.ProductType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class UpdateProductRestModel {
    private String _id;
    private String name;
    private String detail;
    private String photo;
    private String sellerId;
    private List<ProductType> type;
}
