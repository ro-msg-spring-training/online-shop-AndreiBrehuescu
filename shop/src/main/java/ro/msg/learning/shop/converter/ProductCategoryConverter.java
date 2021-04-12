package ro.msg.learning.shop.converter;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.models.ProductCategory;

@Component
public class ProductCategoryConverter extends BaseConvertor<ProductCategory, ProductCategoryDto> {


    public ProductCategory getModel(ProductCategoryDto dto){
        ProductCategory productCategory = ProductCategory.builder()
                                                    .name(dto.getName())
                                                    .description(dto.getDescription())
                                                    .build();
        productCategory.setId(dto.getId());

        return productCategory;
    }

    public ProductCategoryDto getDto(ProductCategory model){
        ProductCategoryDto productCategoryDto = ProductCategoryDto.builder()
                                                    .name(model.getName())
                                                    .description(model.getName())
                                                    .id(model.getId())
                                                    .build();
        return productCategoryDto;
    }

}
