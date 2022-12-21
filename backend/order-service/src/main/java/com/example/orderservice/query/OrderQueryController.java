package com.example.orderservice.query;

import com.example.orderservice.query.rest.OrderRestModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class OrderQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    QueryGateway queryGateway;

    @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
    public List<OrderRestModel> getOrders(){
        return (List<OrderRestModel>) rabbitTemplate.convertSendAndReceive("OrderDirectExchange", "get", "");

    }

}
