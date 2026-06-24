package co.istad.phakley.ite3rdecommerce.features.category;

import co.istad.phakley.ite3rdecommerce.features.category.dto.CategoryResponse;
import co.istad.phakley.ite3rdecommerce.features.category.dto.CreateCategoryRequest;



import org.mapstruct.Mapper;

import java.util.Locale;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Return type = Target
    // Parameter = Source
    Category mapCreateCategoryRequestToCategory(CreateCategoryRequest createCategoryRequest);

    CategoryResponse mapCategoryToCategoryResponse(Category category);

}