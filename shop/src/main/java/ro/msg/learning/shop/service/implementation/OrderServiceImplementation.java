package ro.msg.learning.shop.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.converter.AddressConvertor;
import ro.msg.learning.shop.converter.CustomerConvertor;
import ro.msg.learning.shop.converter.OrderConvertor;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.dto.StockDto;
import ro.msg.learning.shop.models.*;
import ro.msg.learning.shop.repository.*;
import ro.msg.learning.shop.service.interfaces.IOrder;
import ro.msg.learning.shop.stategy.interfaces.IStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderServiceImplementation implements IOrder {

    private final OrderRepository orderRepository;
    private final OrderConvertor orderConvertor;
    private final AddressConvertor addressConvertor;
    private final IStrategy strategy;
    private final AddressRepository addressRepository;
    private final LocationRepository locationRepository;
    private final CustomerConvertor customerConvertor;
    private final ProductRepository productRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final StockRepository stockRepository;

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderTable> orderTableList = this.orderRepository.findAll();

        Collection<OrderDto> orderDtos = this.orderConvertor.convertModelToDto(orderTableList);

        return new ArrayList<>(orderDtos);
    }

    @Override
    public Optional<OrderDto> getOrderById(Integer id) {
        Optional<OrderTable> order = this.orderRepository.findById(id);

        Optional<OrderDto> orderDto = Optional.empty();

        if( order.isEmpty()){
            return orderDto;
        }

        OrderDto orderDto1 = this.orderConvertor.getDto(order.get());

        return Optional.of(orderDto1);
    }

    @Override
    public List<OrderTable> addOrder(OrderDto orderDto) {

        Address address = addressConvertor.getModel(orderDto.getAddress());

        List<StockDto> stockDtos = strategy.findStock(orderDto);

        addressRepository.save(address);

        List<OrderTable> orderTables = new ArrayList<OrderTable>();

        for(StockDto stockDto : stockDtos){
            Optional<Location> location = locationRepository.findById(stockDto.getIdLocation());
            //Optional<Customer> customer = customerRepository.findAllById(orderDto.getCustomerDto().g)

            OrderTable orderTable = OrderTable.builder()
                    .location(location.get())
                    .customer(customerConvertor.getModel(orderDto.getCustomerDto()))
                    .createdAt(orderDto.getCreatedAt())
                    .address(address)
                    .build();

            orderRepository.save(orderTable);
            orderTables.add(orderTable);

            OrderDetail orderDetail = OrderDetail.builder()
                    .orderTable(orderTable)
                    .product(productRepository.findById(stockDto.getIdProduct()).get())
                    .quantity(stockDto.getQuantity())
                    .build();
            orderDetailRepository.save(orderDetail);

            Stock stock = stockRepository.findByProductIdAndAndLocationId(stockDto.getIdProduct(), stockDto.getIdLocation());
            stock.setQuantity(stock.getQuantity() - stockDto.getQuantity());
            stockRepository.save(stock);
        }
        return orderTables;

    }


    @Override
    public void deleteOrderById(Integer id) {
        Optional<OrderTable> order = this.orderRepository.findById(id);

        if( order.isEmpty()){
            return;
        }

        this.orderRepository.deleteById(id);
    }

}
