package com.example.customerservice.core.data;

import com.example.customerservice.pojo.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
    public CustomerEntity findCustomerEntitiesBy_id(String _id);
}
