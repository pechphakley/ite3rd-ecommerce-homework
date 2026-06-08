package co.istad.phakley.ite3rdecommerce.service;

import co.istad.phakley.ite3rdecommerce.dto.CategoryResponse;
import co.istad.phakley.ite3rdecommerce.dto.CreateCategoryRequest;

public interface CategoryService  {
    CategoryResponse createNew(CreateCategoryRequest request);
}
