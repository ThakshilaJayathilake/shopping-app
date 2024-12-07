package com.tnj.microservices.product.service;

import com.tnj.microservices.product.dto.ProductRequest;
import com.tnj.microservices.product.model.Product;
import com.tnj.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
//        log.info("Product" + product.getId() + " is saved");
        log.info("Product {} is saved", product.getId());
        return product;
    }
}