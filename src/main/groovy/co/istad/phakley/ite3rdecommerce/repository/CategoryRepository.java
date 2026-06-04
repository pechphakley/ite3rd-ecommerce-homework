package co.istad.phakley.ite3rdecommerce.repository;

import co.istad.phakley.ite3rdecommerce.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
