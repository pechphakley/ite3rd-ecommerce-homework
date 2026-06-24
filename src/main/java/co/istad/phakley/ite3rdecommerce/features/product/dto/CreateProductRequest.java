package co.istad.phakley.ite3rdecommerce.features.product.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CreateProductRequest(
        @NotBlank(message = "Name is requres")
        @Size(max = 50)
        String name,
        @Size(max = 500)
        String description,
        @NotBlank(message = "Name is requres")
        @Size(max = 255)
        String thumbnail,
        @NotNull(message = "Uniprice is requrie")
        @Min(0)
        BigDecimal unitPrice,

        @NotNull(message = "Qty is require")
        @Min(0)
        Integer qty,
        @NotNull(message = "Category Id is require")
        @Positive
        Integer CategoryId


) {
}
