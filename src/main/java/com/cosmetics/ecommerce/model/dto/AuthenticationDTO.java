package com.cosmetics.ecommerce.model.dto;

import com.cosmetics.ecommerce.model.entity.Costumer;

public record AuthenticationDTO(String login, String password) {
    public AuthenticationDTO(Costumer costumer){
        this(costumer.getLogin(), costumer.getPassword());
    }
}
