package ro.msg.learning.shop.service.interfaces;

import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.models.OrderTable;

import java.util.List;
import java.util.Optional;

public interface IOrder {


    List<OrderDto> getAllOrders();

    Optional<OrderDto> getOrderById(Integer id);

    List<OrderTable> addOrder(OrderDto orderDto);

    void deleteOrderById(Integer id);

}
