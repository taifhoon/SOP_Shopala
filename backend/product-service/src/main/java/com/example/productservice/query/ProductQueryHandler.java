package com.example.productservice.query;

import com.example.productservice.pojo.ProductEntity;
import com.example.productservice.core.data.ProductRepository;
import com.example.productservice.query.rest.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductQueryHandler {

    private final ProductRepository productRepository;

    public ProductQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    List<ProductRestModel> findProducts(FindProductQuery query){
        List<ProductRestModel> productsRest = new ArrayList<>();
        List<ProductEntity> storedProducts = productRepository.findAll();
        for (ProductEntity productEntity : storedProducts) {
            ProductRestModel productRestModel = new ProductRestModel();
            BeanUtils.copyProperties(productEntity, productRestModel);
            productsRest.add(productRestModel);
        }
        return productsRest;
    }

    @QueryHandler
    ProductRestModel findProductsById(FindProductByIdQuery query){
        ProductRestModel productsRest = new ProductRestModel();
        ProductEntity storedProducts = productRepository.findBy_id(query.get_id());
        BeanUtils.copyProperties(storedProducts, productsRest);
        return productsRest;
    }
}
