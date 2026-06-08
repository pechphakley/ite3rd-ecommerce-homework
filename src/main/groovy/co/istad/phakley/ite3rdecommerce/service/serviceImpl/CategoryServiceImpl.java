package co.istad.phakley.ite3rdecommerce.service.serviceImpl;

import co.istad.phakley.ite3rdecommerce.domain.Category;
import co.istad.phakley.ite3rdecommerce.dto.CategoryResponse;
import co.istad.phakley.ite3rdecommerce.dto.CreateCategoryRequest;
import co.istad.phakley.ite3rdecommerce.mapper.CategoryMapper;
import co.istad.phakley.ite3rdecommerce.repository.CategoryRepository;
import co.istad.phakley.ite3rdecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
//  use this  lombok instead constructor
//    public CategoryServiceImpl(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }

    @Override
    public CategoryResponse createNew(CreateCategoryRequest createCategoryRequest) {
        log.info("Create New {}",categoryRepository);

        // validate category name
        boolean isExisting = categoryRepository.existsByName(createCategoryRequest.name());

        // we have study condition
        if (isExisting)
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Category has already existed"
            );
///  this is for validate parent category

        Category parentCategory=null;
        CategoryResponse parentCategoryResponse =null;


        if (createCategoryRequest.parentCategoryId()!=null){
           // return result
          categoryRepository.findById(createCategoryRequest.parentCategoryId())
                 .orElseThrow(()->new ResponseStatusException(
                         HttpStatus.NOT_FOUND,
                         "Parent Category has bot found"
                 ));
          parentCategoryResponse= CategoryResponse.builder()
                    .id(parentCategory.getId())
                    .name(parentCategory.getName())
                    .description(parentCategory.getDescription())
                    .icon(parentCategory.getIcon())
                    .isDeleted(parentCategory.getIsDeleted())
                    .build();
        }


        // after complete validation and here is the mapping dto
        // to mapping dto we have to create object about category
        Category category= categoryMapper
                .mapCreateCategoryRequestToCategory(createCategoryRequest);

        category.setIsDeleted(false);
        category.setParentCategoryId(null);


        // insert if primary key is null;
        //update if primary key is value;
//        categoryRepository.save(category);

        // you  want to get new value use this
        category = categoryRepository.save(category);


        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .icon(category.getIcon())
                .isDeleted(category.getIsDeleted())
                .parentCategory(parentCategoryResponse)
                .build();
    }
}

