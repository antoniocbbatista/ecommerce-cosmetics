package com.cosmetics.ecommerce.model.entity;


import com.cosmetics.ecommerce.model.enums.PaymentStatus;
import com.cosmetics.ecommerce.model.enums.PaymentType;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    private Double price;

    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @ManyToOne
    @JoinColumn(name = "orders_id", nullable = false)
    private Order order;
}
