package ro.msg.learning.shop.converter.interfaces;

public interface IConverter<Model, Dto> {

    Model getModel(Dto dto);

    Dto getDto(Model model);
}