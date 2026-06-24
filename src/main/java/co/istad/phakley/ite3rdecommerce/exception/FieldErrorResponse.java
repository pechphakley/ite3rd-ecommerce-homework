package co.istad.phakley.ite3rdecommerce.exception;

import lombok.Builder;

@Builder
public record FieldErrorResponse(
        String field,
        String message
) {
}
