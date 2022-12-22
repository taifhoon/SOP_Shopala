package com.example.orderservice.command.model;

import com.example.orderservice.pojo.OrderType;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class CreateOrderCommand {

    @TargetAggregateIdentifier
    private String _id;
    private String customerId;
    private String paymentId;
    private Date date;
    private List<OrderType> type;
}
