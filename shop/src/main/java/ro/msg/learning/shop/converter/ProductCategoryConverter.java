package ro.msg.learning.shop.converter;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.models.ProductCategory;

@Component
public class ProductCategoryConverter extends BaseConvertor<ProductCategory, ProductCategoryDto {


    public ProductCategory getEntity(ProductCategoryDto){
        return ProductCategory.builed()
    }

}
