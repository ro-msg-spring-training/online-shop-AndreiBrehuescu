package ro.msg.learning.shop.converter;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.AddressDto;
import ro.msg.learning.shop.models.Address;

@Component
public class AddressConvertor extends  BaseConvertor<Address, AddressDto>{
    @Override
    public Address getModel(AddressDto addressDto) {
        Address address = Address.builder()
                .addressStreetAddress(addressDto.getAddressStreetAddress())
                .addressCity(addressDto.getAddressCity())
                .addressCounty(addressDto.getAddressCounty())
                .addressCountry(addressDto.getAddressCountry())
                .build();

        address.setId(addressDto.getId());

        return address;
    }

    @Override
    public AddressDto getDto(Address address) {
        AddressDto addressDto = AddressDto.builder()
                .id(address.getId())
                .addressCountry(address.getAddressCountry())
                .addressCity(address.getAddressCity())
                .addressCounty(address.getAddressCounty())
                .addressStreetAddress(address.getAddressStreetAddress())
                .build();

        return addressDto;
    }
}
