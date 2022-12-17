package com.example.productservice.command.model;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DelProductCommand {
    @TargetAggregateIdentifier
    private String _id;
}
