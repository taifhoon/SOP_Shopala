package com.example.productservice.command;

import com.example.productservice.command.model.*;
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
    private String _id;
    private String name;
    private BigDecimal price;
    private String color;
    private String size;
    private Integer quantity;

    public ProductAggregate(){
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

    @CommandHandler
    public void updateProduct(UpdateProductCommand updateProductCommand){
        UpdateProductRestModel updateProductRestModel = new UpdateProductRestModel();
        BeanUtils.copyProperties(updateProductCommand, updateProductRestModel);
        AggregateLifecycle.apply(updateProductRestModel);
    }
    @CommandHandler
    public void deleteProduct(DelProductCommand command){
        DelProductRestModel delProductRestModel = new DelProductRestModel();
        BeanUtils.copyProperties(command, delProductRestModel);
        AggregateLifecycle.apply(delProductRestModel);
    }

    @EventSourcingHandler
    public void setProductCreatedEvent(ProductCreatedEvent productCreatedEvent){
        this._id = productCreatedEvent.get_id();
        this.name = productCreatedEvent.getName();
        this.price = productCreatedEvent.getPrice();
        this.color = productCreatedEvent.getColor();
        this.size = productCreatedEvent.getSize();
        this.quantity = productCreatedEvent.getQuantity();
    }

    @EventSourcingHandler
    public void setUpdateProductRestModel(UpdateProductRestModel model){
        this._id = model.get_id();
        this.name = model.getName();
        this.price = model.getPrice();
        this.color = model.getColor();
        this.size = model.getSize();
        this.quantity = model.getQuantity();
    }


}
