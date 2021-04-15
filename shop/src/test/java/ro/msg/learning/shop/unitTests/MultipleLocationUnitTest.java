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
import ro.msg.learning.shop.stategy.MultipleLocationStrategy;
import ro.msg.learning.shop.stategy.SingleLocationStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MultipleLocationUnitTest {

    @Mock
    private StockRepository stockRepository;

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private MultipleLocationStrategy strategy;

    private Location location;
    private List<Location> locations;
    private Product product1;
    private Product product2;
    private StockId stockId;
    private Stock stock;
    private List<Stock> stocks;

    @BeforeEach
    public void init(){
        location = Location.builder()
                .name("testProduct")
                .build();
        location.setId(1);
        locations = new ArrayList<>();
        locations.add(location);
        location = Location.builder()
                .name("testProduct2")
                .build();
        location.setId(2);
        locations.add(location);

        product1 = Product.builder()
                .name("testProduct")
                .build();
        product1.setId(1);

        product2 = Product.builder()
                .name("testProduct2")
                .build();
        product2.setId(2);


        stockId = StockId.builder()
                .idLocation(1)
                .idProduct(1)
                .build();


        stock = Stock.builder()
                .stockId(stockId)
                .product(product1)
                .location(location)
                .quantity(50)
                .build();
        stocks = new ArrayList<>();
        stocks.add(stock);


        stockId = StockId.builder()
                .idLocation(1)
                .idProduct(2)
                .build();


        stock = Stock.builder()
                .stockId(stockId)
                .product(product1)
                .location(location)
                .quantity(50)
                .build();

        Mockito.when(locationRepository.findAll()).thenReturn(locations);
    }


    @Test
    public void stockNotEmpty() {
        Mockito.when(stockRepository.findStockByProductIdAndQuantityGreaterThanEqualOrderByQuantityDesc(product1.getId(),5)).thenReturn(stocks);
        Mockito.when(stockRepository.findStockByProductIdAndQuantityGreaterThanEqualOrderByQuantityDesc(product2.getId(),5)).thenReturn(stocks);

        List<OrderDetailsDto> orderDetailDtos = new ArrayList<>();

        orderDetailDtos.add(
                OrderDetailsDto.builder()
                        .idProduct(product1.getId())
                        .quantity(5)
                        .build()
        );
        orderDetailDtos.add(
                OrderDetailsDto.builder()
                        .idProduct(product2.getId())
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

        Mockito.when(stockRepository.findStockByProductIdAndQuantityGreaterThanEqualOrderByQuantityDesc(product1.getId(),5)).thenReturn(null);
        Mockito.when(stockRepository.findStockByProductIdAndQuantityGreaterThanEqualOrderByQuantityDesc(product2.getId(),5)).thenReturn(null);

        List<OrderDetailsDto> orderDetailDtos = new ArrayList<>();

        orderDetailDtos.add(
                OrderDetailsDto.builder()
                        .idProduct(product1.getId())
                        .quantity(5)
                        .build()
        );
        orderDetailDtos.add(
                OrderDetailsDto.builder()
                        .idProduct(product2.getId())
                        .quantity(5)
                        .build()
        );

        OrderDto orderDto = OrderDto.builder()
                .detailsDtos(orderDetailDtos)
                .build();
        assertThrows(RuntimeException.class, () -> strategy.findStock(orderDto));
    }
}