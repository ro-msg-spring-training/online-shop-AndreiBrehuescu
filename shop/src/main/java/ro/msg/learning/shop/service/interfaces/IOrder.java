package ro.msg.learning.shop.service.interfaces;

import ro.msg.learning.shop.dto.OrderDto;

import java.util.List;
import java.util.Optional;

public interface IOrder {


    List<OrderDto> getAllOrders();

    Optional<OrderDto> getOrderById(Integer id);

    void addOrder(OrderDto orderDto);

    void deleteOrderById(Integer id);

    Optional<OrderDto> update(OrderDto orderDto);

}
