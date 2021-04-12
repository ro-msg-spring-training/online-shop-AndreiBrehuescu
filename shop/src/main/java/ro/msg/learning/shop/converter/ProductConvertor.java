package ro.msg.learning.shop.converter;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.models.Product;
import ro.msg.learning.shop.models.ProductCategory;
import ro.msg.learning.shop.models.Supplier;

import javax.persistence.Converter;

@Component
public class ProductConvertor extends BaseConvertor<Product, ProductDto> {

    @Override
    public Product getModel(ProductDto productDto) {
        ProductCategory productCategory = ProductCategory.builder()
                                                .name(productDto.getProductCategoryDto().getName())
                                                .description(productDto.getProductCategoryDto().getDescription())
                                                .build();
        productCategory.setId(productDto.getProductCategoryDto().getId());


        Supplier supplier = Supplier.builder()
                                .name(productDto.getSupplierDto().getName())
                                .build();
        supplier.setId(productDto.getSupplierDto().getId());


        Product product = Product.builder()
                            .name(productDto.getName())
                            .description(productDto.getDescription())
                            .price(productDto.getPrice())
                            .weight(productDto.getWeight())
                            .productCategory(productCategory)
                            .supplier(supplier)
                            .imageUrl(productDto.getImageUrl())
                            .build();

        product.setId(productDto.getId());
        return product;
    }

    @Override
    public ProductDto getDto(Product product) {

        ProductCategoryDto productCategoryDto = ProductCategoryDto.builder()
                                                    .id(product.getProductCategory().getId())
                                                    .name(product.getProductCategory().getName())
                                                    .description(product.getProductCategory().getDescription())
                                                    .build();

        SupplierDto supplierDto = SupplierDto.builder()
                                    .id(product.getSupplier().getId())
                                    .name(product.getSupplier().getName())
                                    .build();

        ProductDto productDto = ProductDto.builder()
                                    .id(product.getId())
                                    .name(product.getName())
                                    .description(product.getDescription())
                                    .price(product.getPrice())
                                    .weight(product.getWeight())
                                    .productCategoryDto(productCategoryDto)
                                    .supplierDto(supplierDto)
                                    .build();

        return productDto;
    }
}
