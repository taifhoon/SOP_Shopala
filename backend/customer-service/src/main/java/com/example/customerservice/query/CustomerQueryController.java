package com.example.customerservice.query;

import com.example.customerservice.query.rest.CustomerRestModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerQueryController {

    @Autowired
    QueryGateway queryGateway;

    @RequestMapping(value = "/getCustomers", method = RequestMethod.GET)
    public List<CustomerRestModel> getCustomers(){
        FindCustomerQuery findCustomerQuery = new FindCustomerQuery();
        List<CustomerRestModel> customers = queryGateway
                .query(findCustomerQuery, ResponseTypes.multipleInstancesOf(CustomerRestModel.class)).join();
        return customers;
    }
}
