package ro.msg.learning.shop.models;

import lombok.*;

import javax.persistence.Entity;

@Builder
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {

    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreetAddress;
}