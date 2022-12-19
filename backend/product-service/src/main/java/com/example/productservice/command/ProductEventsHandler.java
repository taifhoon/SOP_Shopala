package com.example.productservice.command;


import com.example.productservice.command.model.DelProductCommand;
import com.example.productservice.command.model.DelProductRestModel;
import com.example.productservice.command.model.UpdateProductRestModel;
import com.example.productservice.pojo.ProductEntity;
import com.example.productservice.core.data.ProductRepository;
import com.example.productservice.core.event.ProductCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {

    private final ProductRepository productRepository;

    public ProductEventsHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event){
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);
        productRepository.save(productEntity);
    }
    @EventHandler
    public void on(UpdateProductRestModel event){
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);

        productRepository.save(productEntity);
    }
    @EventHandler
    public void on(DelProductRestModel event){
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);
        productRepository.delete(productEntity);
    }

}
