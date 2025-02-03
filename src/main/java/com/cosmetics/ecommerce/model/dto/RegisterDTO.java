package com.cosmetics.ecommerce.model.dto;

import com.cosmetics.ecommerce.model.entity.Address;
import com.cosmetics.ecommerce.model.entity.Costumer;
import com.cosmetics.ecommerce.model.entity.CostumerRole;

import java.util.List;

public record RegisterDTO(String login, String name, String password, String email, String cpf, String phone, List<Address> address, CostumerRole role) {
    public RegisterDTO(Costumer costumer){
        this(costumer.getLogin(), costumer.getName(), costumer.getPassword(), costumer.getEmail(), costumer.getCpf(), costumer.getPhone(), costumer.getAddress(), costumer.getRole());
    }
}
