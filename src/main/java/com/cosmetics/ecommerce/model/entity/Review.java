package com.cosmetics.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Costumer costumer;

    private Product product;

    private int rating;

    private String comment;

    private LocalDateTime reviewDate;
}
