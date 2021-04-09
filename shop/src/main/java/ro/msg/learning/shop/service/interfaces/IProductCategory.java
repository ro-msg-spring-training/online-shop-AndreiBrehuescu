package ro.msg.learning.shop.service.interfaces;

import ro.msg.learning.shop.models.Product;
import ro.msg.learning.shop.models.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface IProductCategory {

    List<ProductCategory> getAllProductCategories();

    Optional<ProductCategory> getProductCategoryById(Integer id);

    void addProductCategory(ProductCategory productCategory);
}
