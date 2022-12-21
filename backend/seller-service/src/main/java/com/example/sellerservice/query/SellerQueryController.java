package com.example.sellerservice.query;

import com.example.sellerservice.query.rest.SellerRestModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SellerQueryController {
    @Autowired
    QueryGateway queryGateway;

    @RequestMapping(value = "/getSellers", method = RequestMethod.GET)
    public List<SellerRestModel> getSellers(){
        FindSellerQuery findSellerQuery = new FindSellerQuery();
        List<SellerRestModel> sellers = queryGateway
                .query(findSellerQuery, ResponseTypes.multipleInstancesOf(SellerRestModel.class)).join();
        return sellers;
    }
}