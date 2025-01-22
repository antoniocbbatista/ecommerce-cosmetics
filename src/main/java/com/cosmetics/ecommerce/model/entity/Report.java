package com.cosmetics.ecommerce.model.entity;

import com.cosmetics.ecommerce.model.enums.ReportType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime generationDate;

    @Enumerated(EnumType.STRING)
    private ReportType type;

    private String data;
}
