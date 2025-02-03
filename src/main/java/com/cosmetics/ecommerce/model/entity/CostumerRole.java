package com.cosmetics.ecommerce.model.entity;

import lombok.Getter;

@Getter
public enum CostumerRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    CostumerRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
