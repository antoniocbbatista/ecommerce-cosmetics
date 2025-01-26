package com.cosmetics.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "costumer")
public class Costumer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String email;

    private String cpf;

    private String phone;

    @OneToMany(mappedBy = "costumer")
    private List<Address> address;

    @OneToOne(mappedBy = "costumer")
    private Cart cart;
}
