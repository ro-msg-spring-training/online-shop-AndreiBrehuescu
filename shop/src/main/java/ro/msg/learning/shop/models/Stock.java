package ro.msg.learning.shop.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "stock")
@NoArgsConstructor
@AllArgsConstructor
@Getter  @Setter
@ToString
@EqualsAndHashCode
public class Stock {

    @EmbeddedId
    private StockId stockId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProduct")
    @JoinColumn(name = "idProduct")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idLocation")
    @JoinColumn(name = "idLocation")
    private Location location;

    private Integer quantity;
}