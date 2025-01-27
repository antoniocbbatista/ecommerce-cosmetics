package com.cosmetics.ecommerce.model.dto;

import com.cosmetics.ecommerce.model.entity.Category;
import com.cosmetics.ecommerce.model.entity.Product;

import java.util.List;
import java.util.UUID;

public record CategoryDTO(UUID id, String name) {
    public CategoryDTO(Category category) {
        this(category.getId(), category.getName());
    }
}