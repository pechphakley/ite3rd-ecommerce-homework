package co.istad.phakley.ite3rdecommerce.features.file.dto;

import lombok.Builder;

@Builder

public record FileUploadResponse(
        String name,
        String caption,
        Long size,
        String mediaType,

        String uri
) {
}
