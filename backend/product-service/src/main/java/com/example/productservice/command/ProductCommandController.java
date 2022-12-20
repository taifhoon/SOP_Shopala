package com.example.productservice.command;

import com.example.productservice.command.model.*;
import com.example.productservice.pojo.ProductType;
import com.example.productservice.query.ProductQueryController;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController
public class ProductCommandController {

    private final CommandGateway commandGateway;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public ProductCommandController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public String createProduct(@RequestBody CreateProductRestModel model){
        return (String) rabbitTemplate.convertSendAndReceive("ProductDirectExchange", "create", model);
    }
    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public String updateProduct(@RequestBody UpdateProductRestModel model){
        return (String) rabbitTemplate.convertSendAndReceive("ProductDirectExchange", "update", model);
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.DELETE)
    public String deleteProduct(@RequestBody DelProductRestModel model){
        return (String) rabbitTemplate.convertSendAndReceive("ProductDirectExchange", "delete", model);
    }
}
