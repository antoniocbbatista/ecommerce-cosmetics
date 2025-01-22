package com.cosmetics.ecommerce.model.dto;

import java.util.UUID;

public record AddressDTO(UUID id, String street, String number, String complement, String district,
                         String city, String state, String cep) {
}
