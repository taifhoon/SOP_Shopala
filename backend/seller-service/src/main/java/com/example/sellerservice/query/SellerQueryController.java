package com.example.sellerservice.query;

import com.example.sellerservice.query.rest.SellerRestModel;
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
public class SellerQueryController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    QueryGateway queryGateway;

    @RequestMapping(value = "/getSellers", method = RequestMethod.GET)
    public List<SellerRestModel> getSellers(){
        return (List<SellerRestModel>) rabbitTemplate.convertSendAndReceive("SellerDirectExchange", "get", "");
    }
}
