package com.example.productservice.command;

import com.example.productservice.command.model.*;
import com.example.productservice.core.event.ProductCreatedEvent;
import com.example.productservice.pojo.ProductType;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.List;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String _id;
    private String name;
    private String detail;
    private String photo;
    private String sellerId;
    private String categoryId;
    private List<ProductType> type;

    public ProductAggregate(){
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){
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
        this.detail = productCreatedEvent.getDetail();
        this.type = productCreatedEvent.getType();
        this.photo = productCreatedEvent.getPhoto();
        this.sellerId = productCreatedEvent.getSellerId();
        this.categoryId = productCreatedEvent.getCategoryId();
    }

    @EventSourcingHandler
    public void setUpdateProductRestModel(UpdateProductRestModel model){
        this._id = model.get_id();
        this.name = model.getName();
        this.detail = model.getDetail();
        this.type = model.getType();
        this.photo = model.getPhoto();
        this.sellerId = model.getSellerId();
        this.categoryId = model.getCategoryId();
    }

}
