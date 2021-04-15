package ro.msg.learning.shop.unitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ro.msg.learning.shop.dto.OrderDetailsDto;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.models.Location;
import ro.msg.learning.shop.models.Product;
import ro.msg.learning.shop.models.Stock;
import ro.msg.learning.shop.models.StockId;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.stategy.SingleLocationStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SingleLocationUnitTest {

    @Mock
    private StockRepository stockRepository;

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private SingleLocationStrategy strategy;

    @Test
    public void stockNotEmpty() {
        Location location = Location.builder()
                .name("testProduct")
                .build();
        location.setId(1);
        List<Location> locations = new ArrayList<>();
        locations.add(location);

        Product product = Product.builder()
                .name("testProduct")
                .build();
        product.setId(1);

        StockId stockId = StockId.builder()
                .idLocation(1)
                .idProduct(1)
                .build();

        Stock stock = Stock.builder()
                .stockId(stockId)
                .product(product)
                .location(location)
                .quantity(50)
                .build();
        List<Stock> stocks = new ArrayList<>();
        stocks.add(stock);

        Mockito.when(locationRepository.findAll()).thenReturn(locations);

        Mockito.when(stockRepository.findStockByProductIdAndQuantityGreaterThanEqualAndLocationId(product.getId(),5,location.getId())).thenReturn(stocks.get(0));
        List<OrderDetailsDto> orderDetailDtos = new ArrayList<>();
        orderDetailDtos.add(
                OrderDetailsDto.builder()
                        .idProduct(product.getId())
                        .quantity(5)
                        .build()
        );

        OrderDto orderDto = OrderDto.builder()
                .detailsDtos(orderDetailDtos)
                .build();
        assertFalse(strategy.findStock(orderDto).isEmpty());
    }

    @Test
    public void stockNotFound(){
        Location location = Location.builder()
                .name("testProduct")
                .build();
        location.setId(1);
        List<Location> locations = new ArrayList<>();
        locations.add(location);

        Product product = Product.builder()
                .name("testProduct")
                .build();
        product.setId(1);

        StockId stockId = StockId.builder()
                .idLocation(1)
                .idProduct(1)
                .build();

        Stock stock = Stock.builder()
                .stockId(stockId)
                .product(product)
                .location(location)
                .quantity(50)
                .build();
        List<Stock> stocks = new ArrayList<>();
        stocks.add(stock);

        Mockito.when(locationRepository.findAll()).thenReturn(locations);

        Mockito.when(stockRepository.findStockByProductIdAndQuantityGreaterThanEqualAndLocationId(product.getId(),500,location.getId())).thenReturn(stocks.get(0));
        List<OrderDetailsDto> orderDetailDtos = new ArrayList<>();
        orderDetailDtos.add(
                OrderDetailsDto.builder()
                        .idProduct(product.getId())
                        .quantity(500)
                        .build()
        );

        OrderDto orderDto = OrderDto.builder()
                .detailsDtos(orderDetailDtos)
                .build();
        assertThrows(RuntimeException.class, () -> strategy.findStock(orderDto));
    }


}
