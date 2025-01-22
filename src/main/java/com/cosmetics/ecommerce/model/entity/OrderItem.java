package com.cosmetics.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Product product;

    private int quantity;

    private Double unitPrice;

    private Order order;

}
