package ro.msg.learning.shop.converter;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.AddressDto;
import ro.msg.learning.shop.dto.CustomerDto;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.models.Address;
import ro.msg.learning.shop.models.Customer;
import ro.msg.learning.shop.models.OrderTable;


@Component
public class OrderConvertor extends BaseConvertor<OrderTable, OrderDto> {

    @Override
    public OrderTable getModel(OrderDto orderDto) {
        Customer customer = Customer.builder()
                                .firstname(orderDto.getCustomerDto().getFirstname())
                                .lastname(orderDto.getCustomerDto().getLastname())
                                .username(orderDto.getCustomerDto().getUsername())
                                .password(orderDto.getCustomerDto().getPassword())
                                .emailaddress(orderDto.getCustomerDto().getEmailaddress())
                                .build();
        customer.setId(orderDto.getCustomerDto().getId());


        Address address = Address.builder()
                                    .addressCountry(orderDto.getAddress().getAddressCountry())
                                    .addressCity(orderDto.getAddress().getAddressCity())
                                    .addressCounty(orderDto.getAddress().getAddressCounty())
                                    .addressStreetAddress(orderDto.getAddress().getAddressStreetAddress())
                                    .build();

        OrderTable orderTable = OrderTable.builder()
                                .customer(customer)
                                .address(address)
                                .build();
        orderTable.setId(orderDto.getId());

        return orderTable;
    }

    @Override
    public OrderDto getDto(OrderTable orderTable) {
        CustomerDto customerDto = CustomerDto.builder()
                                                .id(orderTable.getCustomer().getId())
                                                .firstname(orderTable.getCustomer().getFirstname())
                                                .lastname(orderTable.getCustomer().getLastname())
                                                .username(orderTable.getCustomer().getUsername())
                                                .password(orderTable.getCustomer().getPassword())
                                                .emailaddress(orderTable.getCustomer().getEmailaddress())
                                                .build();

        AddressDto addressDto = AddressDto.builder()
                                                .id(orderTable.getAddress().getId())
                                                .addressCountry(orderTable.getAddress().getAddressCountry())
                                                .addressCity(orderTable.getAddress().getAddressCity())
                                                .addressCounty(orderTable.getAddress().getAddressCounty())
                                                .addressStreetAddress(orderTable.getAddress().getAddressStreetAddress())
                                                .build();

        OrderDto orderDto = OrderDto.builder()
                                        .id(orderTable.getId())
                                        .customerDto(customerDto)
                                        .createdAt(orderTable.getCreatedAt())
                                        .address(addressDto)
                                        .build();
        return orderDto;
    }
}
