package ro.msg.learning.shop.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "productcategory")
@Getter @Setter
@NoArgsConstructor
public class ProductCategory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;

    private String description;

    @OneToMany(mappedBy = "productCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products;

    public ProductCategory(@NonNull String name, String description, Set<Product> products) {
        this.name = name;
        this.description = description;
        this.products = products;
    }
}
