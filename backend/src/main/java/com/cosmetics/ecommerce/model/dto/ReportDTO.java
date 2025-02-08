package com.cosmetics.ecommerce.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReportDTO(UUID id, LocalDateTime generationDate, String type, String data) {
}
