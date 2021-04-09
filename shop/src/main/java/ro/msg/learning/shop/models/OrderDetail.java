package ro.msg.learning.shop.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orderdetail")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId orderDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idOrder")
    @JoinColumn(name = "idOrder")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProduct")
    @JoinColumn(name = "idProduct")
    private Product product;

    private Integer quantity;
}