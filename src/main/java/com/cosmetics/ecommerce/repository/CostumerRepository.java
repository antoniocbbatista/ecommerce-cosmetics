package com.cosmetics.ecommerce.repository;

import com.cosmetics.ecommerce.model.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface CostumerRepository extends JpaRepository<Costumer, UUID> {
    UserDetails findByLogin(String login);
}
