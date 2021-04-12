package ro.msg.learning.shop.stategy.interfaces;


import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.dto.StockDto;

import java.util.List;

@Component
public interface IStrategy {

    public List<StockDto> findStock(OrderDto orderDto);

}
