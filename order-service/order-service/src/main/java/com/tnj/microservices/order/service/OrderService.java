package com.tnj.microservices.order.service;

import com.tnj.microservices.order.client.InventoryClient;
import com.tnj.microservices.order.dto.OrderRequest;
import com.tnj.microservices.order.model.Order;
import com.tnj.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    @Autowired
    public OrderService(OrderRepository orderRepository, InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }

    public void placeOrder(OrderRequest orderRequest) {
//         1. Using Mockito; provide a mock response & use it to run our test
//        2. Use Wiremock
        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with SkuCode " + orderRequest.skuCode() +  " is not in stock");
        }

    }
}
