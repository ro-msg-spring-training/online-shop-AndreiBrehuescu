package ro.msg.learning.shop.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@Table(name = "location")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Location extends  BaseEntity{

    private String name;

    @OneToOne
    @JoinTable(name = "address")
    private Address address;
}