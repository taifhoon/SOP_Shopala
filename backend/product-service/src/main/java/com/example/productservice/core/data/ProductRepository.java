package com.example.productservice.core.data;

import com.example.productservice.pojo.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {

    public ProductEntity findBy_id(String _id);
}
