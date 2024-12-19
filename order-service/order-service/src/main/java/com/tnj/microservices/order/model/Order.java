package com.tnj.microservices.order.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "t_orders")
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
