package ro.msg.learning.shop.service.interfaces;

import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProduct {
    List<ProductDto> getAllProducts();

    Optional<ProductDto> getProductById(Integer id);

    void addProduct(ProductDto productDto);

    void deleteProductById(Integer id);

    void update(ProductDto productDto);
}

