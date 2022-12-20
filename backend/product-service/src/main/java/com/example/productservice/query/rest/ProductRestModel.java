package com.example.productservice.query.rest;

import com.example.productservice.pojo.ProductType;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductRestModel implements Serializable{

        private String _id;
        private String name;
        private String detail;
        private String photo;
        private String sellerId;
        private String categoryId;
        private List<ProductType> type;

}
