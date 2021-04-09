package ro.msg.learning.shop.models;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@Embeddable
public class StockId implements Serializable {

    private Integer idProduct;
    private Integer idLocation;


}
