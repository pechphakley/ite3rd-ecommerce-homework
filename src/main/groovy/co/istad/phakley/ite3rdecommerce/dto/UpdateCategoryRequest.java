package co.istad.phakley.ite3rdecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateCategoryRequest(
        @NotBlank(message = "Name is required")
        @Size(max = 50)
        String name,
        String description,
        @Size(max = 255)
        String icon

) {
}