package com.cosmetics.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String street;

    private String number;

    private String complement;

    private String district;

    private String city;

    private String state;

    private String cep;

    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;
}
