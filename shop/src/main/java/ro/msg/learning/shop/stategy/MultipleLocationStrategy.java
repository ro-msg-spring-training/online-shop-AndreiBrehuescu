package ro.msg.learning.shop.stategy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.dto.OrderDetailsDto;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.dto.StockDto;
import ro.msg.learning.shop.models.Stock;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.stategy.interfaces.IStrategy;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class MultipleLocationStrategy implements IStrategy {

    private StockRepository stockRepository;

    @Override
    public List<StockDto> findStock(OrderDto orderDto) {
        List<StockDto> stockDtoList = new ArrayList<>();

        for(OrderDetailsDto orderDetailsDto : orderDto.getDetailsDtos()){
            List<Stock> stockList = stockRepository
                    .findStockByProductIdAndQuantityGreaterThanEqualOrderByQuantityDesc(orderDetailsDto.getIdProduct(), orderDetailsDto.getQuantity());

            if(stockList.size() == 0 ){
                throw new RuntimeException("There is no stock for this product!");
            }else{
                Stock stock = stockList.get(0);
                stockDtoList.add(
                        StockDto.builder()
                                .idLocation(stock.getStockId().getIdLocation())
                                .idProduct(stock.getStockId().getIdProduct())
                                .quantity(stock.getQuantity())
                                .build()
                );
            }
        }

        return null;
    }
}
