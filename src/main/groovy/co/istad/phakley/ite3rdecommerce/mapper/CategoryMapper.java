package co.istad.phakley.ite3rdecommerce.mapper;

import co.istad.phakley.ite3rdecommerce.domain.Category;
import co.istad.phakley.ite3rdecommerce.dto.CategoryResponse;
import co.istad.phakley.ite3rdecommerce.dto.CreateCategoryRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper (componentModel = "spring")
public interface CategoryMapper {
    // Return type = Target
    // Parameter = Source
    Category mapCreateCategoryRequestToCategory(CreateCategoryRequest createCategoryRequest);
    CategoryResponse mapCategoryToResponse(Category category);
}