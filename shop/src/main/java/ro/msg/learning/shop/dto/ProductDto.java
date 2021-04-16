package ro.msg.learning.shop.dto;

import lombok.*;
import ro.msg.learning.shop.models.Product;
import ro.msg.learning.shop.models.ProductCategory;
import ro.msg.learning.shop.models.Supplier;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDto implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;

    private ProductCategoryDto productCategoryDto;
    private SupplierDto supplierDto;

    private String imageUrl;

}
