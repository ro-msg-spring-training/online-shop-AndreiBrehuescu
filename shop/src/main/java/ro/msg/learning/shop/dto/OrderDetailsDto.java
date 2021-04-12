package ro.msg.learning.shop.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDetailsDto implements Serializable {

    private Integer idOrder;
    private Integer idProduct;
    private Integer quantity;

}
