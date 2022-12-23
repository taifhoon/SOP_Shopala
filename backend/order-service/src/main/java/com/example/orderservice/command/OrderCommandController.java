package com.example.orderservice.command;

import com.example.orderservice.command.model.CreateOrderCommand;
import com.example.orderservice.command.model.CreateOrderRestModel;
import com.example.orderservice.command.model.DelOrderCommand;
import com.example.orderservice.command.model.DelOrderRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
public class OrderCommandController {
    private final CommandGateway commandGateway;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public OrderCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public String createOrder(@RequestBody CreateOrderRestModel model){
        return (String) rabbitTemplate.convertSendAndReceive("OrderDirectExchange", "create", model);
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    public String deleteOrder(@RequestBody DelOrderRestModel model){
        return (String) rabbitTemplate.convertSendAndReceive("OrderDirectExchange", "delete", model);
    }
}
