package co.istad.phakley.ite3rdecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateCategoryRequest(

        // here is for valide what i have starter-validate
        @NotBlank(message = "Name is requres")
        @Size(max=50)
        String name,
        String description,
        @Size(max = 255)
        String icon,
        @Positive
        Integer parentCategoryId
) {
}
