package com.example.productservice.command.model;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Builder
@Data
public class UpdateProductCommand {

    @TargetAggregateIdentifier
    private final String _id;
    private final String name;
    private final BigDecimal price;
    private final String color;
    private final String size;
    private final Integer quantity;
}
