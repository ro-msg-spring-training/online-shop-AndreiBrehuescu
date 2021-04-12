package ro.msg.learning.shop.service.implementation;

import lombok.RequiredArgsConstructor;
import ro.msg.learning.shop.converter.ProductCategoryConverter;
import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.models.ProductCategory;
import ro.msg.learning.shop.repository.ProductCategoryRepository;
import ro.msg.learning.shop.service.interfaces.IProductCategory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductCategoryServiceImplementation  implements IProductCategory {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryConverter productCategoryConverter;

    @Override
    public List<ProductCategoryDto> getAllProductCategories() {
        List<ProductCategory> productCategoryList = this.productCategoryRepository.findAll();

        Collection<ProductCategoryDto> productCategoryDtoCollection = this.productCategoryConverter.convertModelToDto(productCategoryList);

        return new ArrayList<>(productCategoryDtoCollection);
    }

    @Override
    public Optional<ProductCategoryDto> getProductCategoryById(Integer id) {
        Optional<ProductCategory> productCategory = this.productCategoryRepository.findById(id);

        Optional<ProductCategoryDto> productCategoryDto = Optional.empty();

        if(productCategory.isEmpty()){
            return productCategoryDto;
        }

        ProductCategoryDto productCategoryDto1 = this.productCategoryConverter.getDto(productCategory.get());

        return Optional.of(productCategoryDto1);
    }

    @Override
    public void addProductCategory(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = this.productCategoryConverter.getModel(productCategoryDto);

        this.productCategoryRepository.save(productCategory);
    }

    @Override
    public void deleteProductCategoryById(Integer id) {
        Optional<ProductCategory> productCategory = this.productCategoryRepository.findById(id);

        if(productCategory.isEmpty()){
            return;
        }

        this.productCategoryRepository.deleteById(id);
    }

    @Override
    public void update(ProductCategoryDto productCategoryDto) {
        Optional<ProductCategory> productCategoryModel = this.productCategoryRepository.findById(productCategoryDto.getId());

        if( productCategoryModel.isEmpty()){
            this.productCategoryRepository.save(this.productCategoryConverter.getModel(productCategoryDto));
            return;
        }

        ProductCategory existingProductCategory = productCategoryModel.get();

        ProductCategory newProductCategory = this.productCategoryConverter.getModel(productCategoryDto);

        existingProductCategory.setDescription(newProductCategory.getDescription());
        existingProductCategory.setName(newProductCategory.getName());

        this.productCategoryRepository.save(existingProductCategory);
    }
}
