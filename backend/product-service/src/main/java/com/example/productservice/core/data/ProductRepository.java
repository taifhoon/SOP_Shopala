package com.example.productservice.core.data;

import com.example.productservice.pojo.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {

    @Query(value = "{ '_id' : ?0 }")
    public ProductEntity findProductEntityBy_id(String _id);
}
