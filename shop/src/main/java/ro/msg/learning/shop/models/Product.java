package ro.msg.learning.shop.models;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@Getter @Setter
@NoArgsConstructor
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;


    private String description;

    @NonNull
    private BigDecimal price;

    @NonNull
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


    public Product(@NonNull String name, String description, @NonNull BigDecimal price, @NonNull Double weight, ProductCategory productCategory, Supplier supplier, List<Stock> stock, List<OrderDetail> ordersDetail) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.productCategory = productCategory;
        this.supplier = supplier;
        this.stock = stock;
        this.ordersDetail = ordersDetail;
    }


}
