package com.cosmetics.ecommerce.model.entity;

import com.cosmetics.ecommerce.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.UUID;

@Entity
@Data
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String orderNumber;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Double totalAmount;

    private Costumer costumer;

    private List<OrderItem> orderItems;

    private Payment payment;
}
