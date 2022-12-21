package com.example.orderservice.command;

import com.example.orderservice.command.model.CreateOrderCommand;
import com.example.orderservice.command.model.DelOrderCommand;
import com.example.orderservice.command.model.DelOrderRestModel;
import com.example.orderservice.core.event.OrderCreatedEvent;
import com.example.orderservice.pojo.OrderType;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String _id;
    private List<String> productId;
    private String customerId;
    private String paymentId;
    private List<OrderType> type;

    public OrderAggregate(){}

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command){
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();
        BeanUtils.copyProperties(command, orderCreatedEvent);
        AggregateLifecycle.apply(orderCreatedEvent);
    }

    @EventSourcingHandler
    public void setOrderCreatedEvent(OrderCreatedEvent orderCreatedEvent){
        this._id = orderCreatedEvent.get_id();
        this.productId = orderCreatedEvent.getProductId();
        this.customerId = orderCreatedEvent.getCustomerId();
        this.paymentId = orderCreatedEvent.getPaymentId();
        this.type = orderCreatedEvent.getType();
    }

    @CommandHandler
    public void deleteOrder(DelOrderCommand command){
        DelOrderRestModel delOrderRestModel = new DelOrderRestModel();
        BeanUtils.copyProperties(command, delOrderRestModel);
        AggregateLifecycle.apply(delOrderRestModel);
    }
}
