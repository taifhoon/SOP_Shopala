package com.example.orderservice.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("Order")
public class OrderEntity implements Serializable {
    @Id
    private String _id;
    private String productId;
    private String customerId;
    private String paymentId;
}
