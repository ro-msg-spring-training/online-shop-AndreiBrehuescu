package ro.msg.learning.shop.service.interfaces;

import ro.msg.learning.shop.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProduct {
    List<Product> getAllProducts();

    void addProduct(Product product);

    Optional<Product> getProductById(Integer id);

    void deleteProductById(Integer id);
}

