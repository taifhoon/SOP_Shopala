package com.example.orderservice.command.model;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateOrderCommand {

    @TargetAggregateIdentifier
    private String _id;
    private String productId;
    private String customerId;
    private String paymentId;
}
