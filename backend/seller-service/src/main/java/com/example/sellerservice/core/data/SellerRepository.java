package com.example.sellerservice.core.data;

import com.example.sellerservice.pojo.SellerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerRepository extends MongoRepository<SellerEntity, String> {
    public SellerEntity findSellerEntitiesBy_id(String _id);
}
