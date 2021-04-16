package ro.msg.learning.shop.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerDto implements Serializable {

    private Integer id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String emailaddress;
}