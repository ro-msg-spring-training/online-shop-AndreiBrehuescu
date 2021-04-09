package ro.msg.learning.shop.models;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "customer")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Customer extends BaseEntity{

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String emailaddress;

}