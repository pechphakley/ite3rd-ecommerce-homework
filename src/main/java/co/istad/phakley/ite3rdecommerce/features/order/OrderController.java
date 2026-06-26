package co.istad.phakley.ite3rdecommerce.features.order;

import co.istad.phakley.ite3rdecommerce.features.order.dto.CreateOrderRequest;
import co.istad.phakley.ite3rdecommerce.features.order.dto.OrderResponse;
import co.istad.phakley.ite3rdecommerce.features.order.dto.UpdateStatusRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@Valid @RequestBody CreateOrderRequest request) {
        return orderService.createNew(request);
    }

    @GetMapping
    public Page<OrderResponse> findAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "orderedAt") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        return orderService.findAllOrders(pageable);
    }

    @GetMapping("/{id}")
    public OrderResponse findOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @PutMapping("/{id}/soft-delete")
    public OrderResponse softDeleteOrder(@PathVariable Long id) {
        return orderService.softDeleteOrder(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void hardDeleteOrder(@PathVariable Long id) {
        orderService.hardDeleteOrder(id);
    }

    @PutMapping("/{id}/status")
    public OrderResponse updatePaymentStatus(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStatusRequest request
    ) {
        return orderService.updatePaymentStatus(id, request);
    }
}