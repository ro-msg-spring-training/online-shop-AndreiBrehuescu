package ro.msg.learning.shop.stategy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.dto.OrderDetailsDto;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.dto.StockDto;
import ro.msg.learning.shop.models.Location;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.stategy.interfaces.IStrategy;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
public class SingleLocationStrategy implements IStrategy {

    private StockRepository stockRepository;
    private LocationRepository locationRepository;


    public List<StockDto> findStock(OrderDto orderDto){

        List<Location> locations = locationRepository.findAll();

        for(Location location : locations){

            for(OrderDetailsDto orderDetailsDto : orderDto.getDetailsDtos()){
                List<StockDto> stocks = new ArrayList<>();
                    /////// TO DO
            }
        }


        return null;
    }

}