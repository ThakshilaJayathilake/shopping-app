package com.tnj.microservices.product.controller;

import com.tnj.microservices.product.dto.ProductRequest;
import com.tnj.microservices.product.model.Product;
import com.tnj.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }
}