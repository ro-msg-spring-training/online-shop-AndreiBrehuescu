package ro.msg.learning.shop.models;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter @Setter
@NoArgsConstructor
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String firstname;

    @NonNull
    private String lastname;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String emailaddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Order> orders;

    public Customer(@NonNull String firstname, @NonNull String lastname, @NonNull String username, @NonNull String password, @NonNull String emailaddress, List<Order> orders) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.emailaddress = emailaddress;
        this.orders = orders;
    }
}
