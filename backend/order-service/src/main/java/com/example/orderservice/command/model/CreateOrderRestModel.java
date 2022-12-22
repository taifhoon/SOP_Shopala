package com.example.orderservice.command.model;

import com.example.orderservice.pojo.OrderType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CreateOrderRestModel implements Serializable {
    private String customerId;
    private String paymentId;
    private List<OrderType> type;
}
