package co.istad.phakley.ite3rdecommerce.features.product;

import co.istad.phakley.ite3rdecommerce.features.product.dto.CreateProductRequest;
import co.istad.phakley.ite3rdecommerce.features.product.dto.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
 Product mapCreateProductRequestToProduct(CreateProductRequest createProductRequest);

 ProductResponse mapProductToProductResponse(Product product);

}


