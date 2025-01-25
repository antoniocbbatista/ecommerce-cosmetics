package com.cosmetics.ecommerce.model.dto;

import com.cosmetics.ecommerce.model.entity.Category;

import java.util.UUID;

public record ProductDTO(UUID id, String name, String description, Double price, String imageUrl, int stock, Category category) {
}
