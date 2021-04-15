package ro.msg.learning.shop.stategy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.dto.OrderDetailsDto;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.dto.StockDto;
import ro.msg.learning.shop.models.Location;
import ro.msg.learning.shop.models.Stock;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.stategy.interfaces.IStrategy;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class SingleLocationStrategy implements IStrategy {

    private StockRepository stockRepository;
    private LocationRepository locationRepository;

    @Override
    public List<StockDto> findStock(OrderDto orderDto) {
        boolean found = true;

        for(Location location : locationRepository.findAll()) {
            found = true;
            List<StockDto> stockDtoList = new ArrayList<>();
            for (OrderDetailsDto orderDetails : orderDto.getDetailsDtos()) {
                Stock stockList = stockRepository
                        .findStockByProductIdAndQuantityGreaterThanEqualAndLocationId(orderDetails.getIdProduct(), orderDetails.getQuantity(), location.getId());

                if(stockList == null || stockList.getQuantity() < orderDetails.getQuantity()){
                    found = false;
                    break;
                }
                Stock stock = stockList;
                stockDtoList.add(
                        StockDto.builder()
                                .idLocation(stock.getStockId().getIdLocation())
                                .idProduct(stock.getStockId().getIdProduct())
                                .quantity(orderDetails.getQuantity())
                                .build()
                );
            }

            if( found ){
                return stockDtoList;
            }
        }
        throw new RuntimeException("Strategy could not find the stock!");
    }
}
