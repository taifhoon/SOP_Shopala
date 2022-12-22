package com.example.orderservice.core.event;

import com.example.orderservice.pojo.OrderType;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderCreatedEvent {
    private String _id;
    private List<String> productId;
    private String customerId;
    private String paymentId;
    private Date date;
    private List<OrderType> type;
}
