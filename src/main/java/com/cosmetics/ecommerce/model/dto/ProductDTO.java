package com.cosmetics.ecommerce.model.dto;

import com.cosmetics.ecommerce.model.entity.Category;
import com.cosmetics.ecommerce.model.entity.Product;

import java.util.UUID;

public record ProductDTO(UUID id, String name, String description, Double price, Category category, String imageUrl, int stock) {

    public ProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
                product.getCategory(), product.getImageUrl(), product.getStock());
    }
}
