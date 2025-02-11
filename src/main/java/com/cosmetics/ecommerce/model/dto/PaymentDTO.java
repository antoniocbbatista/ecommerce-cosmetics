package com.cosmetics.ecommerce.model.dto;

import com.cosmetics.ecommerce.model.entity.Order;

import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentDTO(UUID id, String paymentType, Double price, LocalDateTime paymentDate, String status, Order order) {
}
