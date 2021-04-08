package ro.msg.learning.shop.models;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "supplier")
@Getter @Setter
@NoArgsConstructor
public class Supplier {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products;

    public Supplier(@NonNull String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }
}
