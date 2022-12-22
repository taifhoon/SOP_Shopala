package com.example.customerservice.query;

import com.example.customerservice.query.rest.CustomerRestModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CustomerQueryController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    QueryGateway queryGateway;

    @RequestMapping(value = "/getCustomers", method = RequestMethod.GET)
    public List<CustomerRestModel> getCustomers(){
        return (List<CustomerRestModel>) rabbitTemplate.convertSendAndReceive("CustomerDirectExchange", "get", "");

    }
}
