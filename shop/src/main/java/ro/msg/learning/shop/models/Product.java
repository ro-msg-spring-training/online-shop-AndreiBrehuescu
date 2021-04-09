package ro.msg.learning.shop.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity{

    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProductCategory", nullable = false)
    private ProductCategory productCategory;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idSupplier", nullable = false)
    private Supplier supplier;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Stock> stock;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<OrderDetail> ordersDetail;

}