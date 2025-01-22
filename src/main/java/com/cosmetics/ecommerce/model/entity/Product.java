package com.cosmetics.ecommerce.model.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String description;

    private Double price;

    private String imageUrl;

    private int stock;

    private Category category;

    private List<Review> reviews;

}
