package ro.msg.learning.shop.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "stock")
@IdClass(OrderDetailId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter  @Setter
@ToString
@EqualsAndHashCode
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
}
