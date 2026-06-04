package co.istad.phakley.ite3rdecommerce.repository;

import co.istad.phakley.ite3rdecommerce.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OderRepository extends JpaRepository<Order, UUID> {

}
