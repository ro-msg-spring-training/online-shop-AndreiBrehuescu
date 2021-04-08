package ro.msg.learning.shop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter @Setter
public class OrderDetailId implements Serializable {

    private Integer idOrder;

    private Integer idProdcut;

    public OrderDetailId(Integer idOrder, Integer idProdcut) {
        this.idOrder = idOrder;
        this.idProdcut = idProdcut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailId that = (OrderDetailId) o;
        return Objects.equals(idOrder, that.idOrder) && Objects.equals(idProdcut, that.idProdcut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, idProdcut);
    }
}
