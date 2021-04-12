package ro.msg.learning.shop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

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