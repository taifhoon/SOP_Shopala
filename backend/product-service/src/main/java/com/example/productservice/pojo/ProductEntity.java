package com.example.productservice.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Document("Product")
public class ProductEntity implements Serializable {
    @Id
    private String _id;
    private String name;
    private List<ProductType> type;
}
