package co.istad.phakley.ite3rdecommerce.features.category;


import co.istad.phakley.ite3rdecommerce.features.category.dto.CategoryResponse;
import co.istad.phakley.ite3rdecommerce.features.category.dto.CreateCategoryRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CategoryResponse createNew(@Valid @RequestBody CreateCategoryRequest createCategoryRequest) {
        return categoryService.createNew(createCategoryRequest);
    }
}