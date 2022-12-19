package com.example.orderservice.command.model;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DelOrderCommand {
    @TargetAggregateIdentifier
    private String _id;
}
