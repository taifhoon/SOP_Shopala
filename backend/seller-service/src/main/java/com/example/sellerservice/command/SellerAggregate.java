package com.example.sellerservice.command;

import com.example.sellerservice.command.model.CreateSellerCommand;
import com.example.sellerservice.command.model.UpdateSellerCommand;
import com.example.sellerservice.command.model.UpdateSellerRestModel;
import com.example.sellerservice.core.event.SellerCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class SellerAggregate {

    @AggregateIdentifier
    private String _id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private String bank;
    private String accountNumber;


    public SellerAggregate(){}

    @CommandHandler
    public SellerAggregate(CreateSellerCommand createSellerCommand){

        SellerCreatedEvent sellerCreatedEvent = new SellerCreatedEvent();
        BeanUtils.copyProperties(createSellerCommand, sellerCreatedEvent);
        AggregateLifecycle.apply(sellerCreatedEvent);
    }

    @CommandHandler
    public void updateSeller(UpdateSellerCommand updateSellerCommand){
        UpdateSellerRestModel updateSellerRestModel = new UpdateSellerRestModel();
        BeanUtils.copyProperties(updateSellerCommand, updateSellerRestModel);
        AggregateLifecycle.apply(updateSellerRestModel);
    }

    @EventSourcingHandler
    public void setSellerCreatedEvent(SellerCreatedEvent sellerCreatedEvent){
        this._id = sellerCreatedEvent.get_id();
        this.username = sellerCreatedEvent.getUsername();
        this.password = sellerCreatedEvent.getPassword();
        this.name = sellerCreatedEvent.getName();
        this.email = sellerCreatedEvent.getEmail();
        this.address = sellerCreatedEvent.getAddress();
        this.bank = sellerCreatedEvent.getBank();
        this.accountNumber = sellerCreatedEvent.getAccountNumber();
    }

    @EventSourcingHandler
    public void setUpdateSellerRestModel(UpdateSellerRestModel model){
        this._id = model.get_id();
        this.username = model.getUsername();
        this.password = model.getPassword();
        this.name = model.getName();
        this.email = model.getEmail();
        this.address = model.getAddress();
        this.bank = model.getBank();
        this.accountNumber = model.getAccountNumber();
    }


}
