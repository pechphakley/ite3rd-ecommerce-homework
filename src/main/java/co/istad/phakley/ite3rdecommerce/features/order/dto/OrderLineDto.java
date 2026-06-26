package co.istad.phakley.ite3rdecommerce.features.order.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record OrderLineDto(
        @NotBlank( message = "code is require")
        String code,
        @Positive
        @NotBlank(message = "qty is require")
        Integer qty,
        @NotNull(message = "uniPrice is require")
        BigDecimal unitPrice
) {
}

// it is subject order it take form order line

