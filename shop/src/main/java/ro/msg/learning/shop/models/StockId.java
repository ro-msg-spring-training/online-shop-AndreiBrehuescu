package ro.msg.learning.shop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter @Setter
public class StockId implements Serializable {

    private Integer idProduct;

    private Integer idLocation;


    public StockId(Integer idProduct, Integer idLocation) {
        this.idProduct = idProduct;
        this.idLocation = idLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockId stockId = (StockId) o;
        return Objects.equals(idProduct, stockId.idProduct) && Objects.equals(idLocation, stockId.idLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, idLocation);
    }
}
