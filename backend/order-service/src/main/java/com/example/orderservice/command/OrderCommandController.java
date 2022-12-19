package com.example.orderservice.command;

import com.example.orderservice.command.model.CreateOrderCommand;
import com.example.orderservice.command.model.CreateOrderRestModel;
import com.example.orderservice.command.model.DelOrderCommand;
import com.example.orderservice.command.model.DelOrderRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderCommandController {
    private final CommandGateway commandGateway;

    @Autowired
    public OrderCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public String createOrder(@RequestBody CreateOrderRestModel model){
        CreateOrderCommand command = CreateOrderCommand.builder()
                ._id(UUID.randomUUID().toString())
                .productId(model.getProductId())
                .customerId(model.getCustomerId())
                .paymentId(model.getPaymentId())
                .build();

        String result;
        try {
            result = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.DELETE)
    public String deleteOrder(@RequestBody DelOrderRestModel model){
        DelOrderCommand command = DelOrderCommand.builder()
                ._id(model.get_id())
                .build();
        String result;
        try {
            commandGateway.sendAndWait(command);
            result = "Delete Success\nOrder Id: " + command.get_id();
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }
}
