package co.istad.phakley.ite3rdecommerce.dto;

import lombok.Builder;

@Builder
public record CategoryResponse(
        Integer id,
        String name,
        String description,
        String icon,
        Boolean isDeleted,
        CategoryResponse parentCategory
) {
}
