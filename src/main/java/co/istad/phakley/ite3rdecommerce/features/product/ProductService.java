package co.istad.phakley.ite3rdecommerce.features.product;

import co.istad.phakley.ite3rdecommerce.features.product.dto.CreateProductRequest;
import co.istad.phakley.ite3rdecommerce.features.product.dto.ProductResponse;
import org.springframework.data.domain.Page;

public interface ProductService {
    /*
    *Create new product
    * param: createProductRequest
    * create product
    * return ProductResponse
     */

    Page<ProductResponse> findAll( int pageNumber,int pageSize);
    ProductResponse createNew(CreateProductRequest createProductRequest);
}
