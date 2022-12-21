package com.example.customerservice.command;

import com.example.customerservice.command.model.CreateCustomerCommand;
import com.example.customerservice.command.model.UpdateCustomerCommand;
import com.example.customerservice.command.model.UpdateCustomerRestModel;
import com.example.customerservice.core.event.CustomerCreatedEvent;
import com.example.customerservice.query.FindCustomerQuery;
import com.example.customerservice.query.rest.CustomerRestModel;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Aggregate
public class CustomerAggregate {
    @AggregateIdentifier
    private String _id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private List<String> favoriteProductId;

    @Autowired
    QueryGateway queryGateway;

    public CustomerAggregate(){}

    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command){
        CustomerCreatedEvent customerCreatedEvent = new CustomerCreatedEvent();
        BeanUtils.copyProperties(command, customerCreatedEvent);
        AggregateLifecycle.apply(customerCreatedEvent);
    }

    @CommandHandler
    public void updateCustomer(UpdateCustomerCommand updateCustomerCommand){
        UpdateCustomerRestModel updateCustomerRestModel = new UpdateCustomerRestModel();
        BeanUtils.copyProperties(updateCustomerCommand, updateCustomerRestModel);
        AggregateLifecycle.apply(updateCustomerRestModel);
    }

    @EventSourcingHandler
    public void setCustomerCreatedEvent(CustomerCreatedEvent customerCreatedEvent){
        this._id = customerCreatedEvent.get_id();
        this.username = customerCreatedEvent.getUsername();
        this.password = customerCreatedEvent.getPassword();
        this.name = customerCreatedEvent.getName();
        this.email = customerCreatedEvent.getEmail();
        this.address = customerCreatedEvent.getAddress();
        this.favoriteProductId = customerCreatedEvent.getFavoriteProductId();
    }

    @EventSourcingHandler
    public void setUpdateCustomerRestModel(UpdateCustomerRestModel model){
        this._id = model.get_id();
        this.username = model.getUsername();
        this.password = model.getPassword();
        this.name = model.getName();
        this.email = model.getEmail();
        this.address = model.getAddress();
        this.favoriteProductId = model.getFavoriteProductId();
    }

}
