package com.example.sellerservice.query;

import com.example.sellerservice.core.data.SellerRepository;
import com.example.sellerservice.pojo.SellerEntity;
import com.example.sellerservice.query.rest.SellerRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellerQueryHandler {

    private final SellerRepository sellerRepository;

    public SellerQueryHandler(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @QueryHandler
    List<SellerRestModel> findSellers(FindSellerQuery query){
        List<SellerRestModel> sellerRest = new ArrayList<>();
        List<SellerEntity> storedSellers = sellerRepository.findAll();
        for (SellerEntity sellerEntity : storedSellers) {
            SellerRestModel sellerRestModel = new SellerRestModel();
            BeanUtils.copyProperties(sellerEntity, sellerRestModel);
            sellerRest.add(sellerRestModel);
        }
        return sellerRest;
    }
}
