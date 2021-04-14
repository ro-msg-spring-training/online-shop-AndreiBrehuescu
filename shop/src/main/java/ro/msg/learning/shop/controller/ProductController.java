package ro.msg.learning.shop.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.service.implementation.ProductServiceImplementation;
import ro.msg.learning.shop.service.interfaces.IProduct;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final IProduct productService;

    @GetMapping("/products")
    public List<ProductDto> getProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDto getProduct(@PathVariable Integer id){
        Optional<ProductDto> productDtoOptional = this.productService.getProductById(id);

        if(productDtoOptional.isEmpty()){
            return null;
        }

        return productDtoOptional.get();
    }

    @PostMapping(value = "/products")
    public ResponseEntity<Object> addProduct(@RequestBody ProductDto productDto){
        this.productService.addProduct(productDto);

        return new ResponseEntity<>("Product added", HttpStatus.CREATED);
    }


    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id){
        this.productService.deleteProductById(id);

        //return new ResponseEntity<>("Product deleted", HttpStatus.CREATED);
        return;
    }


    @PutMapping("/products/{id}")
    @ResponseBody
    public ProductDto updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto){
        Optional<ProductDto> productDto1 = this.productService.update(productDto);

        if( productDto1.isEmpty()){
            return null;
        }

        return productDto1.get();
    }

}
