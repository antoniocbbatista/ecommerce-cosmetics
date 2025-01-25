package com.cosmetics.ecommerce.model.dto;

import com.cosmetics.ecommerce.model.entity.Address;
import java.util.UUID;

public record CostumerDTO(UUID id, String name, String email, String cpf, String phone, Address address) {
}
