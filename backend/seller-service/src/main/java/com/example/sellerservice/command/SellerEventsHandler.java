package com.example.sellerservice.command;

import com.example.sellerservice.command.model.UpdateSellerRestModel;
import com.example.sellerservice.core.data.SellerRepository;
import com.example.sellerservice.core.event.SellerCreatedEvent;
import com.example.sellerservice.pojo.SellerEntity;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SellerEventsHandler {
    private final SellerRepository sellerRepository;

    public SellerEventsHandler(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @EventHandler
    public void on(SellerCreatedEvent event){
        SellerEntity sellerEntity = new SellerEntity();
        BeanUtils.copyProperties(event, sellerEntity);
        sellerRepository.save(sellerEntity);
    }

    @EventHandler
    public void on(UpdateSellerRestModel event){
        SellerEntity sellerEntity = new SellerEntity();
        BeanUtils.copyProperties(event, sellerEntity);
        sellerRepository.save(sellerEntity);
    }
}
