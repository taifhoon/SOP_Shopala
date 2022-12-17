package com.example.productservice.query;

import com.example.productservice.query.FindProductQuery;
import com.example.productservice.query.rest.ProductRestModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductQueryController {

    @Autowired
    QueryGateway queryGateway;

    @RequestMapping(value = "/getProducts", method = RequestMethod.GET)
    public List<ProductRestModel> getProducts(){
        FindProductQuery findProductQuery = new FindProductQuery();
        List<ProductRestModel> products = queryGateway
                .query(findProductQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
        return products;
    }
}
