package co.istad.phakley.ite3rdecommerce.features.product.dto;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public record ProductResponse(
        String code,

        String slug,

        String name,

        String description,

        String thumbnail,

        BigDecimal unitPrice,

        Integer qty,

        Boolean isAvailable,

        Boolean isDeleted

) {
}
