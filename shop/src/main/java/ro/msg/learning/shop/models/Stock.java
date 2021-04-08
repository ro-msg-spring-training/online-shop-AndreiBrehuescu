package ro.msg.learning.shop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "stock")
@IdClass(OrderDetailId.class)
@NoArgsConstructor
@Getter  @Setter
public class Stock {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduct")
    private Product product;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLocation")
    private Location location;

    private Integer quantity;

    public Stock(Product product, Location location, Integer quantity) {
        this.product = product;
        this.location = location;
        this.quantity = quantity;
    }
}
