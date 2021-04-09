package ro.msg.learning.shop.dto;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductCategoryDto {

    private Integer id;
    private String name;
    private String description;

}