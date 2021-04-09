package ro.msg.learning.shop.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "supplier")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Supplier extends BaseEntity{

    private String name;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products;

}
