package ro.msg.learning.shop.models;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode
public class StockId implements Serializable {

    private Integer idProduct;
    private Integer idLocation;

}
