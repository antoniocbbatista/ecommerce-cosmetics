package com.cosmetics.ecommerce.model.dto;

import com.cosmetics.ecommerce.model.entity.Address;
import com.cosmetics.ecommerce.model.entity.Costumer;

import java.util.List;
import java.util.UUID;

public record CostumerDTO(UUID id, String name, String email, String cpf, String phone, List<Address> address) {
    public CostumerDTO(Costumer costumer){
        this(costumer.getId(), costumer.getName(), costumer.getEmail(), costumer.getCpf(), costumer.getPhone(), costumer.getAddress());
    }
}
