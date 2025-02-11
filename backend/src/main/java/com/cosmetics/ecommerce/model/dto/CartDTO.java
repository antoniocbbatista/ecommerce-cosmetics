package com.cosmetics.ecommerce.model.dto;

import com.cosmetics.ecommerce.model.entity.CartItem;
import com.cosmetics.ecommerce.model.entity.Costumer;

import java.util.List;
import java.util.UUID;

public record CartDTO(UUID id, Costumer costumer, List<CartItem> cartItems) {
}
