package co.istad.phakley.ite3rdecommerce.repository;

import co.istad.phakley.ite3rdecommerce.domain.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
}
