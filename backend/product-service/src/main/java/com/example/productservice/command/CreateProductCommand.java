package com.example.productservice.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Builder
@Data
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private final String productId;
    private final String name;
    private final BigDecimal price;
    private final String color;
    private final String size;
    private final Integer quantity;
}
