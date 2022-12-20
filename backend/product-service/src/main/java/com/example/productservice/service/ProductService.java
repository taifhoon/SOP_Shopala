package com.example.productservice.service;

import com.example.productservice.command.model.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final CommandGateway commandGateway;

    @Autowired
    public ProductService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


    @RabbitListener(queues = "CreateProduct")
    public String CreateProduct(CreateProductRestModel model){
        CreateProductCommand command = CreateProductCommand.builder()
                ._id(UUID.randomUUID().toString())
                .name(model.getName())
                .detail(model.getDetail())
                .photo(model.getPhoto())
                .sellerId(model.getSellerId())
                .categoryId(model.getCategoryId())
                .type(model.getType())
                .build();
        String result= "";
        try {
            result = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }
    @RabbitListener(queues = "UpdateProduct")
    public String UpdateProduct(UpdateProductRestModel model) {
        UpdateProductCommand command = UpdateProductCommand.builder()
                ._id(model.get_id())
                .name(model.getName())
                .detail(model.getDetail())
                .photo(model.getPhoto())
                .sellerId(model.getSellerId())
                .type(model.getType())
                .build();
        String result;
        try {
            commandGateway.sendAndWait(command);
            result = "Update Success \nProduct Id: " + command.get_id() + "\nName: " + command.getName();
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }
    @RabbitListener(queues = "DeleteProduct")
    public String DeleteProduct(DelProductRestModel model){
        DelProductCommand command = DelProductCommand.builder()
                ._id(model.get_id())
                .build();
        String result;
        try {
            commandGateway.sendAndWait(command);
            result = "Delete Success \nProduct Id: " + command.get_id();
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }
}
