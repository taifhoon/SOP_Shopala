package com.example.customerservice.query;

import com.example.customerservice.core.data.CustomerRepository;
import com.example.customerservice.pojo.CustomerEntity;
import com.example.customerservice.query.rest.CustomerRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerQueryHandler {
    private final CustomerRepository customerRepository;

    public CustomerQueryHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @QueryHandler
    List<CustomerRestModel> findProducts(FindCustomerQuery query){
        List<CustomerRestModel> customerRest = new ArrayList<>();
        List<CustomerEntity> storedCustomers = customerRepository.findAll();
        for (CustomerEntity customerEntity : storedCustomers) {
            CustomerRestModel customerRestModel = new CustomerRestModel();
            BeanUtils.copyProperties(customerEntity, customerRestModel);
            customerRest.add(customerRestModel);
        }
        return customerRest;
    }
}
