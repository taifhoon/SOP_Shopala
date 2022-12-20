package com.example.orderservice.query;

import com.example.orderservice.query.rest.OrderRestModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
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
    QueryGateway queryGateway;

    @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
    public List<OrderRestModel> getOrders(){
        FindOrderQuery findOrderQuery = new FindOrderQuery();
        List<OrderRestModel> orders = queryGateway
                .query(findOrderQuery, ResponseTypes.multipleInstancesOf(OrderRestModel.class)).join();
        return orders;
    }

}
