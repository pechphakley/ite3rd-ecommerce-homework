package co.istad.phakley.ite3rdecommerce.features.order;

import co.istad.phakley.ite3rdecommerce.features.order.dto.CreateOrderRequest;
import co.istad.phakley.ite3rdecommerce.features.order.dto.OrderResponse;
import co.istad.phakley.ite3rdecommerce.features.order.dto.UpdateStatusRequest;
import co.istad.phakley.ite3rdecommerce.features.product.Product;
import co.istad.phakley.ite3rdecommerce.features.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderResponse createNew(CreateOrderRequest createOrderRequest) {
        List<OrderLine> orderLines = new ArrayList<>();
        boolean isValidOrder = createOrderRequest.orderLines().stream()
                .allMatch(orderLineDto -> {

                    Optional<Product> productOptional = productRepository
                            .findByCode(orderLineDto.code());

                    if (productOptional.isPresent()) {
                        OrderLine orderLine = new OrderLine();
                        orderLine.setProduct(productOptional.get());
                        orderLine.setQty(orderLineDto.qty());
                        orderLine.setUnitPrice(orderLineDto.unitPrice());
                        orderLines.add(orderLine);
                        return true;
                    }
                    return false;

                });
        if (!isValidOrder) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid product code");
        }

        Order order = new Order();
        order.setAddress(createOrderRequest.address());
        order.setDiscount(createOrderRequest.discount());
        order.setRemark(createOrderRequest.remark());
        order.setOrderLines(orderLines);
        order.setCustomerId("ISTAD");
        order.setIsDeleted(false);
        order.setOrderedAt(LocalDateTime.now());
        order.setStatus(false);

        order = orderRepository.save(order);

        return orderMapper.mapOrderToOrderResponse(order);
    }

    @Override
    public Page<OrderResponse> findAllOrders(Pageable pageable) {
        // Only return non-deleted orders
        Page<Order> orders = orderRepository.findByIsDeletedFalse(pageable);
        return orders.map(orderMapper::mapOrderToOrderResponse);
    }

    @Override
    public OrderResponse findOrderById(Long id) {
        Order order = orderRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Order not found with id: " + id
                ));
        return orderMapper.mapOrderToOrderResponse(order);
    }

    @Override
    @Transactional
    public OrderResponse softDeleteOrder(Long id) {
        Order order = orderRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Order not found with id: " + id
                ));

        order.setIsDeleted(true);
        order = orderRepository.save(order);

        return orderMapper.mapOrderToOrderResponse(order);
    }

    @Override
    @Transactional
    public void hardDeleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Order not found with id: " + id
                ));

        orderRepository.delete(order);
    }

    @Override
    @Transactional
    public OrderResponse updatePaymentStatus(Long id, UpdateStatusRequest request) {
        Order order = orderRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Order not found with id: " + id
                ));

        order.setStatus(request.status());
        order = orderRepository.save(order);

        return orderMapper.mapOrderToOrderResponse(order);
    }
}