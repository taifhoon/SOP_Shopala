package com.example.productservice.command.model;

import com.example.productservice.pojo.ProductType;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateProductRestModel implements Serializable {

    private String name;
    private String detail;
    private String photo;
    private String sellerId;
    private String categoryId;
    private List<ProductType> type;
}
