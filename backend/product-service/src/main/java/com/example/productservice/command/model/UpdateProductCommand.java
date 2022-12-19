package com.example.productservice.command.model;

import com.example.productservice.pojo.ProductType;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class UpdateProductCommand {

    @TargetAggregateIdentifier
    private final String _id;
    private final String name;
    private final String detail;
    private final String photo;
    private final String sellerId;
    private final List<ProductType> type;
}
