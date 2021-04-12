package ro.msg.learning.shop.stategy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.dto.StockDto;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.stategy.interfaces.IStrategy;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class MostAbundantStrategy implements IStrategy {

    private StockRepository stockRepository;

    @Override
    public List<StockDto> findStock(OrderDto orderDto) {
        return null;
    }
    /// TO DO
}
