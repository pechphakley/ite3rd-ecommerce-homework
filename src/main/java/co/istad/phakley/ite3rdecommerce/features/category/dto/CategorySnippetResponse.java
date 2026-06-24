package co.istad.phakley.ite3rdecommerce.features.category.dto;

import lombok.Builder;

@Builder
public record CategorySnippetResponse(
        Integer id,
        String name
) {
}