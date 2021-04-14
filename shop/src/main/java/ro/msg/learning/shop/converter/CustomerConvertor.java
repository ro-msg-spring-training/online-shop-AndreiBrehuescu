package ro.msg.learning.shop.converter;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.AddressDto;
import ro.msg.learning.shop.dto.CustomerDto;
import ro.msg.learning.shop.models.Address;
import ro.msg.learning.shop.models.Customer;

@Component
public class CustomerConvertor  extends  BaseConvertor<Customer, CustomerDto>{

    @Override
    public Customer getModel(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .firstname(customerDto.getFirstname())
                .lastname(customerDto.getLastname())
                .username(customerDto.getUsername())
                .password(customerDto.getPassword())
                .emailaddress(customerDto.getEmailaddress())
                .build();
        customer.setId(customerDto.getId());

        return customer;
    }

    @Override
    public CustomerDto getDto(Customer customer) {
        CustomerDto customerDto = CustomerDto.builder()
                .id(customer.getId())
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .username(customer.getUsername())
                .password(customer.getPassword())
                .emailaddress(customer.getEmailaddress())
                .build();

        return customerDto;
    }
}
