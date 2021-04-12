package ro.msg.learning.shop.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.converter.ProductCategoryConverter;
import ro.msg.learning.shop.converter.ProductConvertor;
import ro.msg.learning.shop.converter.SupplierConvertor;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.models.Product;
import ro.msg.learning.shop.models.ProductCategory;
import ro.msg.learning.shop.models.Supplier;
import ro.msg.learning.shop.repository.ProductRepository;
import ro.msg.learning.shop.service.interfaces.IProduct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImplementation implements IProduct {

    private final ProductRepository productRepository;
    private final ProductConvertor productConvertor;
    private final ProductCategoryConverter productCategoryConverter;
    private final SupplierConvertor supplierConvertor;


    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList = this.productRepository.findAll();

        Collection<ProductDto> productDtos = this.productConvertor.convertModelToDto(productList);

        return new ArrayList<>(productDtos);
    }

    @Override
    public Optional<ProductDto> getProductById(Integer id) {
        Optional<Product> product = this.productRepository.findById(id);

        Optional<ProductDto> productDto = Optional.empty();

        if(product.isEmpty()){
            return productDto;
        }

        ProductDto productDto1 = this.productConvertor.getDto(product.get());

        return Optional.of(productDto1);
    }

    @Override
    public void addProduct(ProductDto productDto) {
        Product product = this.productConvertor.getModel(productDto);

        this.productRepository.save(product);
    }

    @Override
    public void deleteProductById(Integer id) {
        Optional<Product> product = this.productRepository.findById(id);

        if( product.isEmpty() ){
            return;
        }

        this.productRepository.deleteById(id);

    }

    @Override
    public Optional<ProductDto> update(ProductDto productDto) {
        Optional<Product> productModel = this.productRepository.findById(productDto.getId());


        if( productModel.isEmpty()){
            this.productRepository.save(this.productConvertor.getModel(productDto));
            return Optional.of(productDto);
        }

        Supplier supplier = this.supplierConvertor.getModel(productDto.getSupplierDto());
        ProductCategory productCategory = this.productCategoryConverter.getModel(productDto.getProductCategoryDto());

        Product existingProduct = productModel.get();
        Product newProduct = this.productConvertor.getModel(productDto);

        existingProduct.setProductCategory(productCategory);
        existingProduct.setSupplier(supplier);
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setImageUrl(productDto.getImageUrl());
        existingProduct.setWeight(productDto.getWeight());
        existingProduct.setName(productDto.getName());

        this.productRepository.save(existingProduct);

        return Optional.of(productDto);
    }
}
