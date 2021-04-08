package ro.msg.learning.shop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "order")
@Getter @Setter
@NoArgsConstructor
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLocation")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCustomer")
    private Customer customer;

    @NonNull
    private Timestamp createdAt;

    @NonNull
    private String addressCountry;

    @NonNull
    private String addressCity;

    @NonNull
    private String addressCounty;

    private String addressStreetAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderDetail> ordersDetails;


    public Order(Location location, Customer customer, @NonNull Timestamp createdAt, @NonNull String addressCountry, @NonNull String addressCity, @NonNull String addressCounty, String addressStreetAddress, List<OrderDetail> ordersDetails) {
        this.location = location;
        this.customer = customer;
        this.createdAt = createdAt;
        this.addressCountry = addressCountry;
        this.addressCity = addressCity;
        this.addressCounty = addressCounty;
        this.addressStreetAddress = addressStreetAddress;
        this.ordersDetails = ordersDetails;
    }
}
