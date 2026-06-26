package co.istad.phakley.ite3rdecommerce.features.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Find orders that are not deleted with pagination
    Page<Order> findByIsDeletedFalse(Pageable pageable);

    // Find order by ID and ensure it's not deleted
    Optional<Order> findByIdAndIsDeletedFalse(Long id);
}