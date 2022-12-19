package com.example.productservice.service;

import com.example.productservice.command.model.CreateProductCommand;
import com.example.productservice.core.data.ProductRepository;
import com.example.productservice.core.event.ProductCreatedEvent;
import com.example.productservice.pojo.ProductEntity;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @RabbitListener(queues = "CreateProduct")
    public void CreateProduct(ProductEntity entity){
        productRepository.save(entity);
    }


    public List<ProductEntity> showProduct() {return productRepository.findAll();}

    public ProductEntity findByProductId(String id){
        try {
            ProductEntity productEntity = productRepository.findProductEntityBy_id(id);
            return productEntity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
