package com.example.productservice.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Document("Product")
public class Product implements Serializable {
    @Id
    private String productId;
    private String name;
    private BigDecimal price;
    private String color;
    private String size;
    private Integer quantity;
}
