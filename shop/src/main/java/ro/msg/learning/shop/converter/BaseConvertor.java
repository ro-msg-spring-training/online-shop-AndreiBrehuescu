package ro.msg.learning.shop.converter;

import ro.msg.learning.shop.converter.interfaces.IConverter;

import java.util.Collection;
import java.util.stream.Collectors;


public abstract class BaseConvertor<Entity, Dto> implements IConverter<Entity, Dto> {

    public Collection<Entity> convertDtoToEntity(Collection<Dto> dtos){
        return dtos.stream()
                .map(this::getEntity)
                .collect(Collectors.toList());
    }

    public Collection<Dto> convertEntityToDto(Collection<Entity> entities){
        return entities.stream()
                .map(this::getDto)
                .collect(Collectors.toList());
    }
}