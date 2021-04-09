package ro.msg.learning.shop.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDetailsDto implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    private String imageUrl;

    private Integer productCategoryId;
    private String productCategoryName;
    private String productCategoryDescription;

    private Integer supplierId;
    private Integer supplierName;

}