package ro.msg.learning.shop.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductLessDetailsDto implements Serializable {

    private Integer id;
    private Double weight;
}
