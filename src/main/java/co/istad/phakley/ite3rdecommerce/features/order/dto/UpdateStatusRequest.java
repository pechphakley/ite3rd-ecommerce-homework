package co.istad.phakley.ite3rdecommerce.features.order.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateStatusRequest(
        @NotNull(message = "Status is required")
        Boolean status
) {}