package com.example.customerservice.command;

import com.example.customerservice.command.model.CreateCustomerCommand;
import com.example.customerservice.command.model.CreateCustomerRestModel;
import com.example.customerservice.command.model.UpdateCustomerCommand;
import com.example.customerservice.command.model.UpdateCustomerRestModel;
import com.example.customerservice.query.FindCustomerQuery;
import com.example.customerservice.query.rest.CustomerRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class CustomerCommandController {
    private final CommandGateway commandGateway;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private QueryGateway queryGateway;

    @Autowired
    public CustomerCommandController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }


    @RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
    public String createCustomer(@RequestBody CreateCustomerRestModel model){
        return (String) rabbitTemplate.convertSendAndReceive("CustomerDirectExchange", "create", model);
    }

    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public String updateCustomer(@RequestBody UpdateCustomerRestModel model){
        return (String) rabbitTemplate.convertSendAndReceive("CustomerDirectExchange", "update", model);
    }
}
