package ro.msg.learning.shop.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orderdetail")
@IdClass(OrderDetailId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode
public class OrderDetail {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOrder")
    private Order order;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduct")
    private Product product;

    private Integer quantity;

}
