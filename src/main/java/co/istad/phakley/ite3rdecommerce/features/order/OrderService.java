package co.istad.phakley.ite3rdecommerce.features.order;


import co.istad.phakley.ite3rdecommerce.features.order.dto.OrderResponse;
import co.istad.phakley.ite3rdecommerce.features.order.dto.UpdateStatusRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Page<OrderResponse> findAllOrders(Pageable pageable);

    OrderResponse findOrderById(Long id);

    OrderResponse softDeleteOrder(Long id);

    void hardDeleteOrder(Long id);

    OrderResponse updatePaymentStatus(Long id, UpdateStatusRequest request);
}
