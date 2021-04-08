package ro.msg.learning.shop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "location")
@Getter @Setter
@NoArgsConstructor
public class Location {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String addressCountry;

    @NonNull
    private String addressCity;

    @NonNull
    private String addressCounty;

    private String adressStreetAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location", cascade = CascadeType.ALL)
    private List<Revenue> revenueList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location", cascade = CascadeType.ALL)
    private List<Stock> stocks;


    public Location(@NonNull String name, @NonNull String addressCountry, @NonNull String addressCity, @NonNull String addressCounty, String adressStreetAddress, List<Revenue> revenueList, List<Order> orders, List<Stock> stocks) {
        this.name = name;
        this.addressCountry = addressCountry;
        this.addressCity = addressCity;
        this.addressCounty = addressCounty;
        this.adressStreetAddress = adressStreetAddress;
        this.revenueList = revenueList;
        this.orders = orders;
        this.stocks = stocks;
    }
}
