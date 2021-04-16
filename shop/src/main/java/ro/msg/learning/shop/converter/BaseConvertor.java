package ro.msg.learning.shop.converter;

import ro.msg.learning.shop.converter.interfaces.IConverter;

import java.util.Collection;
import java.util.stream.Collectors;


public abstract class BaseConvertor<Model, Dto> implements IConverter<Model, Dto> {

    public Collection<Model> convertDtoToEntity(Collection<Dto> dtos){
        return dtos.stream()
                .map(this::getModel)
                .collect(Collectors.toList());
    }

    public Collection<Dto> convertModelToDto(Collection<Model> entities){
        return entities.stream()
                .map(this::getDto)
                .collect(Collectors.toList());
    }
}