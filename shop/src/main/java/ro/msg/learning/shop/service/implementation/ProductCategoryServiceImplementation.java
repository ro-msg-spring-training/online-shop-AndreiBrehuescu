package ro.msg.learning.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.models.ProductCategory;
import ro.msg.learning.shop.repository.ProductCategoryRepository;
import ro.msg.learning.shop.service.interfaces.IProductCategory;

import java.util.List;
import java.util.Optional;

public class ProductCategoryServiceImplementation  implements IProductCategory {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return this.productCategoryRepository.findAll();
    }

    @Override
    public Optional<ProductCategory> getProductCategoryById(Integer id) {
        return this.productCategoryRepository.findById(id);
    }

    @Override
    public void addProductCategory(ProductCategory productCategory) {
        this.productCategoryRepository.save(productCategory);
    }
}
