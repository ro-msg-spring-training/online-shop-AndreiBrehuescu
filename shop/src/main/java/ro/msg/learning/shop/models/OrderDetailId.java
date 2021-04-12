package ro.msg.learning.shop.models;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Embeddable
@EqualsAndHashCode
public class OrderDetailId implements Serializable {

    private Integer idOrder;
    private Integer idProduct;

}