package com.cosmetics.ecommerce.model.dto;

import com.cosmetics.ecommerce.model.entity.Category;
import com.cosmetics.ecommerce.model.entity.Product;

import java.util.UUID;

public record ProductDTO(UUID id, String name, String description, Double price,
                         String imageUrl, int stock, CategoryDTO category) {
    public ProductDTO(Product product) {
        this(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImageUrl(),
                product.getStock(),
                product.getCategory() != null ? new CategoryDTO(product.getCategory()) : null
        );
    }
}