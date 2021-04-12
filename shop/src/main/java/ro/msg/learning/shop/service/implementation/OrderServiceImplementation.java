package ro.msg.learning.shop.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.converter.OrderConvertor;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.repository.OrderRepository;
import ro.msg.learning.shop.service.interfaces.IOrder;
import ro.msg.learning.shop.stategy.interfaces.IStrategy;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderServiceImplementation implements IOrder {

    private final OrderRepository orderRepository;
    private final OrderConvertor orderConvertor;

    @Override
    public List<OrderDto> getAllOrders() {
        return null;
    }

    @Override
    public Optional<OrderDto> getOrderById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void addOrder(OrderDto orderDto) {

    }

    @Override
    public void deleteOrderById(Integer id) {

    }

    @Override
    public Optional<OrderDto> update(OrderDto orderDto) {
        return Optional.empty();
    }
}
