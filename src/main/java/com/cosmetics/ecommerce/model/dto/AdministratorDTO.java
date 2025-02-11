package com.cosmetics.ecommerce.model.dto;

import java.util.UUID;

public record AdministratorDTO(UUID id, String name, String email, String password) {
}
