package com.cosmetics.ecommerce.model.dto;

import com.cosmetics.ecommerce.model.entity.Costumer;
import com.cosmetics.ecommerce.model.entity.Product;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReviewDTO(UUID id, Costumer costumer, Product product, int rating, String comment, LocalDateTime reviewDate) {
}
