package co.istad.phakley.ite3rdecommerce.features.category;

import co.istad.phakley.ite3rdecommerce.features.category.dto.CategoryResponse;
import co.istad.phakley.ite3rdecommerce.features.category.dto.CreateCategoryRequest;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    CategoryResponse createNew(CreateCategoryRequest createCategoryRequest);

}