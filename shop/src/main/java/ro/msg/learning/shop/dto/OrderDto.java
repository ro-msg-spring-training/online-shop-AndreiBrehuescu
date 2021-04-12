package ro.msg.learning.shop.dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDto implements Serializable {

    private Timestamp timestamp;

    private AddressDto address;
    private List<ProductLessDetailsDto> products;

    private Integer idCustomer;

}
