package co.istad.phakley.ite3rdecommerce.repository;

import co.istad.phakley.ite3rdecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
