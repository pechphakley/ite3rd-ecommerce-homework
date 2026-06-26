package co.istad.phakley.ite3rdecommerce.features.order.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;
@Builder
public record OrderResponse(
        UUID id,
        String customerId,
        String address,
        Float discount,
        String remark,
        Boolean status,
        LocalDateTime  orderedAt,
        Boolean isDeleted

) {
}
