package ro.msg.learning.shop.converter.interfaces;

public interface IConverter<Entity, Dto> {

    Entity getEntity(Dto dto);

    Dto getDto(Entity entity);
}