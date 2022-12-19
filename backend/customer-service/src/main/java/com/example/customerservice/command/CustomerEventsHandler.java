package com.example.customerservice.command;

import com.example.customerservice.command.model.UpdateCustomerRestModel;
import com.example.customerservice.core.data.CustomerRepository;
import com.example.customerservice.core.event.CustomerCreatedEvent;
import com.example.customerservice.pojo.CustomerEntity;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerEventsHandler {
    private final CustomerRepository customerRepository;

    public CustomerEventsHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

   @EventHandler
    public void on(CustomerCreatedEvent event){
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(event, customerEntity);
        customerRepository.save(customerEntity);
    }

    @EventHandler
    public void on(UpdateCustomerRestModel event){
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(event, customerEntity);
        customerRepository.save(customerEntity);
    }
}
