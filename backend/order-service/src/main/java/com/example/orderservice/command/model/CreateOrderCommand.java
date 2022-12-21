package com.example.orderservice.command.model;

import com.example.orderservice.pojo.OrderType;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.List;

@Data
@Builder
public class CreateOrderCommand {

    @TargetAggregateIdentifier
    private String _id;
    private List<String> productId;
    private String customerId;
    private String paymentId;
    private List<OrderType> type;
}
