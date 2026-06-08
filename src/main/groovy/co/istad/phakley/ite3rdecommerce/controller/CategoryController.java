package co.istad.phakley.ite3rdecommerce.controller;

import co.istad.phakley.ite3rdecommerce.dto.CategoryResponse;
import co.istad.phakley.ite3rdecommerce.dto.CreateCategoryRequest;
import co.istad.phakley.ite3rdecommerce.dto.UpdateCategoryRequest;
import co.istad.phakley.ite3rdecommerce.service.CategoryService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CategoryResponse createNewCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest) {
        return categoryService.createNewCategory(createCategoryRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<CategoryResponse> getAllCategory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size) {
        return categoryService.getAllCategory(page, size);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/subcategories")
    public List<CategoryResponse> getSubcategoriesByMainCategoryId(@PathVariable Integer id) {
        return categoryService.getSubcategoriesByMainCategoryId(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void hardDeleteCategoryById(@PathVariable Integer id) {
        categoryService.hardDeleteCategoryById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public CategoryResponse softDeleteCategoryById(@PathVariable Integer id) {
        return categoryService.softDeleteCategoryById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public CategoryResponse updateCategoryFieldsById(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateCategoryRequest updateCategoryRequest) {
        return categoryService.updateCategoryFieldsById(id, updateCategoryRequest);
    }
}
