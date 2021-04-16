package ro.msg.learning.shop.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.LocationDto;
import ro.msg.learning.shop.models.Location;

@Component
@RequiredArgsConstructor
public class LocationConvertor extends BaseConvertor<Location, LocationDto>{

    private final AddressConvertor addressConvertor;

    @Override
    public Location getModel(LocationDto locationDto) {
        Location location = Location.builder()
                .name(locationDto.getName())
                .address(addressConvertor.getModel(locationDto.getAddressDto()))
                .build();
        location.setId(locationDto.getId());

        return location;
    }

    @Override
    public LocationDto getDto(Location location) {
        LocationDto locationDto = LocationDto.builder()
                .id(location.getId())
                .name(location.getName())
                .addressDto(addressConvertor.getDto(location.getAddress()))
                .build();
        return locationDto;
    }
}
