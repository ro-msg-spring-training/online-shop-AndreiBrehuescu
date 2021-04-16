package ro.msg.learning.shop.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategory extends BaseEntity{

    private String name;
    private String description;

}