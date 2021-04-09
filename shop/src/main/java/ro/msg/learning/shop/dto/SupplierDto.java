package ro.msg.learning.shop.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SupplierDto implements Serializable {

    private Integer id;
    private String name;

}
