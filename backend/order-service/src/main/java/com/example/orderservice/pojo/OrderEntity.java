package com.example.orderservice.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Document("Order")
public class
OrderEntity implements Serializable {
    @Id
    private String _id;
    private String customerId;
    private String paymentId;
    private Date date;
    private double sumPrice;
    private List<OrderType> type;
}
