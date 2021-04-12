package ro.msg.learning.shop.converter;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.models.Order;


@Component
public class OrderConvertor extends BaseConvertor<Order, OrderDto> {

    @Override
    public Order getModel(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto getDto(Order order) {
        return null;
    }
}
