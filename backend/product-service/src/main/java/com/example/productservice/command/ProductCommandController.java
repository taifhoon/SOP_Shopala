package com.example.productservice.command;

import com.example.productservice.command.model.*;
import com.example.productservice.pojo.ProductType;
import com.example.productservice.query.ProductQueryController;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductCommandController {

    private final CommandGateway commandGateway;

    @Autowired
    public ProductCommandController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public String createProduct(@RequestBody CreateProductRestModel model){

        CreateProductCommand command = CreateProductCommand.builder()
                ._id(UUID.randomUUID().toString())
                .name(model.getName())
                .detail(model.getDetail())
                .photo(model.getPhoto())
                .sellerId(model.getSellerId())
                .type(model.getType())
                .build();
        System.out.println("Test");
        String result;
        try {
            result = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }
    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public String updateProduct(@RequestBody UpdateProductRestModel model){
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
            result = "Update Success Product Id: " + command.get_id() + "\nName: "+ command.getName();
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.DELETE)
    public String deleteProduct(@RequestBody DelProductRestModel model){
        DelProductCommand command = DelProductCommand.builder()
                ._id(model.get_id())
                .build();
        String result;
        try {
            commandGateway.sendAndWait(command);
            result = "Delete Success Product Id: " + command.get_id();
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }
}
