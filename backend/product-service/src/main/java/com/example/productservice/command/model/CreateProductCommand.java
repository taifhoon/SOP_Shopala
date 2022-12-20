package com.example.productservice.command.model;

import com.example.productservice.pojo.ProductType;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private String _id;
    private String name;
    private String detail;
    private String photo;
    private String sellerId;
    private String categoryId;
    private List<ProductType> type;
}
