package ro.msg.learning.shop.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AddressDto implements Serializable {

    private Integer id;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreetAddress;

}
