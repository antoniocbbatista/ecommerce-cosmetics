package com.cosmetics.ecommerce.model.dto;

import com.cosmetics.ecommerce.model.entity.Costumer;
import com.cosmetics.ecommerce.model.entity.OrderItem;
import com.cosmetics.ecommerce.model.entity.Payment;
import com.cosmetics.ecommerce.model.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderDTO(UUID id, String orderNumber, LocalDateTime orderDate, OrderStatus status, Double totalAmount, Costumer costumer, List<OrderItem> orderItems, Payment payment) {
}
