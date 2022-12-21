package com.example.productservice.service;

import com.example.productservice.command.model.*;
import com.example.productservice.query.FindProductByIdQuery;
import com.example.productservice.query.FindProductQuery;
import com.example.productservice.query.rest.ProductRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final CommandGateway commandGateway;

    @Autowired
    private QueryGateway queryGateway;

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
        String result;
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
                .categoryId(model.getCategoryId())
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

    @RabbitListener(queues = "GetProducts")
    public List<ProductRestModel> getProducts(){
        FindProductQuery findProductQuery = new FindProductQuery();
        List<ProductRestModel> products = queryGateway
                .query(findProductQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
        return products;
    }

//    @RabbitListener(queues = "GetProductById")
//    public ProductRestModel getProductById(String id){
//        FindProductByIdQuery findProductByIdQuery = new FindProductByIdQuery(id);
//        ProductRestModel products = queryGateway
//                .query(findProductByIdQuery, ProductRestModel.class).join();
//        return products;
//    }
}
