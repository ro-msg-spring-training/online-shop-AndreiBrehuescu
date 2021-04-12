package ro.msg.learning.shop.service.interfaces;

import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.models.Product;
import ro.msg.learning.shop.models.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface IProductCategory {

    List<ProductCategoryDto> getAllProductCategories();

    Optional<ProductCategoryDto> getProductCategoryById(Integer id);

    void addProductCategory(ProductCategoryDto productCategoryDto);

    void deleteProductCategoryById(Integer id);

    void update(ProductCategoryDto productCategoryDto);
}
