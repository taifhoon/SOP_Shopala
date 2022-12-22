package com.example.sellerservice.command;

import com.example.sellerservice.command.model.CreateSellerCommand;
import com.example.sellerservice.command.model.CreateSellerRestModel;
import com.example.sellerservice.command.model.UpdateSellerCommand;
import com.example.sellerservice.command.model.UpdateSellerRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
public class SellerCommandController {
    private final CommandGateway commandGateway;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public SellerCommandController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    @RequestMapping(value = "/createSeller", method = RequestMethod.POST)
    public String createSeller(@RequestBody CreateSellerRestModel model){
        return (String) rabbitTemplate.convertSendAndReceive("SellerDirectExchange", "create", model);
    }

    @RequestMapping(value = "/updateSeller", method = RequestMethod.POST)
    public String updateSeller(@RequestBody UpdateSellerRestModel model){
        return (String) rabbitTemplate.convertSendAndReceive("SellerDirectExchange", "update", model);
    }
}
