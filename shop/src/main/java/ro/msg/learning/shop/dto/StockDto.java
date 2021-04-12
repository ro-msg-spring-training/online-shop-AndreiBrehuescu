package ro.msg.learning.shop.dto;


import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StockDto implements Serializable {

    private Integer id;

    private Integer idProduct;

    private Integer idLocation;

    private Integer quantity;
}
