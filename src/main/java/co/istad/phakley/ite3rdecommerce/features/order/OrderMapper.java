package co.istad.phakley.ite3rdecommerce.features.order;

import co.istad.phakley.ite3rdecommerce.features.order.dto.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderResponse mapOrderToOrderResponse(Order order);
}
