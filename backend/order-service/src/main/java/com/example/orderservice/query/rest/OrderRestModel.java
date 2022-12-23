package com.example.orderservice.query.rest;

import com.example.orderservice.pojo.OrderType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class OrderRestModel implements Serializable {
    private String _id;
    private String customerId;
    private String paymentId;
    private Date date;
    private double sumPrice;
    private List<OrderType> type;
}
