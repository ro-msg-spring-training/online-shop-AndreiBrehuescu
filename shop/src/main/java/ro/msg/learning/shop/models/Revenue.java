package ro.msg.learning.shop.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "revenue")
@Getter @Setter
@NoArgsConstructor
public class Revenue {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLocation")
    private Location location;

    @NonNull
    private Timestamp date;

    @NonNull
    private BigDecimal sum;


    public Revenue(Location location, @NonNull Timestamp date, @NonNull BigDecimal sum) {
        this.location = location;
        this.date = date;
        this.sum = sum;
    }
}
