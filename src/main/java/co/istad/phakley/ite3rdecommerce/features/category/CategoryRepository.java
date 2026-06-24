package co.istad.phakley.ite3rdecommerce.features.category;

import co.istad.phakley.ite3rdecommerce.features.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    boolean existsByName(String name);

}