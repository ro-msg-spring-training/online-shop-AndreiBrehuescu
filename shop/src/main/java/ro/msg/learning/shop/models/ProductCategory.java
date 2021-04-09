package ro.msg.learning.shop.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "productcategory")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductCategory extends BaseEntity{

    private String name;
    private String description;

    @OneToMany(mappedBy = "productCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products;

}
