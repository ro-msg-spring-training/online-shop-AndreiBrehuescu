package ro.msg.learning.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.models.Product;
import ro.msg.learning.shop.repository.ProductRepository;
import ro.msg.learning.shop.service.interfaces.IProduct;

import java.util.List;
import java.util.Optional;

public class ProductServiceImplementation implements IProduct {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void deleteProductById(Integer id) {
        this.productRepository.deleteById(id);
    }
}
