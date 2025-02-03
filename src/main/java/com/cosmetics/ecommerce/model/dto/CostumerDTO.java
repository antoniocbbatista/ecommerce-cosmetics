package com.cosmetics.ecommerce.model.dto;

import com.cosmetics.ecommerce.model.entity.Address;
import com.cosmetics.ecommerce.model.entity.Costumer;
import com.cosmetics.ecommerce.model.entity.CostumerRole;

import java.util.List;
import java.util.UUID;

public record CostumerDTO(UUID id,String login, String name, String email, String cpf, String phone, List<Address> address, CostumerRole role) {
    public CostumerDTO(Costumer costumer){
        this(costumer.getId(), costumer.getLogin(), costumer.getName(), costumer.getEmail(), costumer.getCpf(), costumer.getPhone(), costumer.getAddress(), costumer.getRole());
    }
}
