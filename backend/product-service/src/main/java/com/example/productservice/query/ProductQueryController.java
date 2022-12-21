package com.example.productservice.query;

import com.example.productservice.query.FindProductQuery;
import com.example.productservice.query.rest.ProductRestModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductQueryController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    QueryGateway queryGateway;

    @RequestMapping(value = "/getProducts", method = RequestMethod.GET)
    public List<ProductRestModel> getProducts(){
        return (List<ProductRestModel>) rabbitTemplate.convertSendAndReceive("ProductDirectExchange", "get", "");

    }
//    @RequestMapping(value = "/getProductsById/{id}", method = RequestMethod.GET)
//    public ProductRestModel getProductById(@RequestParam String id){
//        return (ProductRestModel) rabbitTemplate.convertSendAndReceive("ProductDirectExchange", "getById", id);
//    }
}
