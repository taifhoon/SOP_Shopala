package com.example.productservice.command;

import com.example.productservice.core.event.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private String color;
    private String size;
    private Integer quantity;

    public  ProductAggregate(){
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){
        if(createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Price cannot be less than or equal to zero");
        }
        if(createProductCommand.getName() == null || createProductCommand.getName().isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand, productCreatedEvent);
        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        this.productId = productCreatedEvent.getProductId();
        this.name = productCreatedEvent.getName();
        this.price = productCreatedEvent.getPrice();
        this.color = productCreatedEvent.getColor();
        this.size = productCreatedEvent.getSize();
        this.quantity = productCreatedEvent.getQuantity();
    }
}
