package ro.msg.learning.shop.integrationTest;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ro.msg.learning.shop.ShopApplication;
import ro.msg.learning.shop.converter.AddressConvertor;
import ro.msg.learning.shop.dto.AddressDto;
import ro.msg.learning.shop.dto.CustomerDto;
import ro.msg.learning.shop.dto.OrderDetailsDto;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.models.*;
import ro.msg.learning.shop.repository.*;
import ro.msg.learning.shop.service.implementation.OrderServiceImplementation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ShopApplication.class)
@ActiveProfiles("test")
public class OrderTest {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private AddressConvertor addressConvertor;

    @Autowired
    private OrderServiceImplementation orderService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private SupplierRepository supplierRepository;


    private Product product1;
    private Product product2;
    private Address address;
    private Location location;
    private StockId stockId;
    private StockId stockId2;
    private Stock stock1;
    private ProductCategory productCategory;
    private Supplier supplier;

    @Before
    public void init()
    {
        productCategory = ProductCategory.builder()
                .name("ChipsTest")
                .description("Chipsuri de cartofi")
                .build();
        productCategory.setId(1);
        productCategory = productCategoryRepository.save(productCategory);

        supplier = Supplier.builder()
                .name("ChioSupplier")
                .build();
        supplier.setId(1);
        supplier = supplierRepository.save(supplier);

        product1 = Product.builder()
                .name("product1")
                .description("test product1")
                .price(BigDecimal.valueOf(10))
                .productCategory(productCategory)
                .supplier(supplier)
                .build();
        product1.setId(51);
        product1 = productRepository.save(product1);


        product2 = Product.builder()
                .name("product2")
                .description("test product2")
                .price(BigDecimal.valueOf(20))
                .productCategory(productCategory)
                .supplier(supplier)
                .build();
        product2.setId(52);
        product2 = productRepository.save(product2);

        address = Address.builder()
                .addressStreetAddress("addresTest")
                .addressCity("addresTest")
                .addressCounty("addresTest")
                .addressCountry("addresTest")
                .build();
        address.setId(4);
        address = addressRepository.save(address);


        location = Location.builder()
                .name("Test location")
                .address(address)
                .build();
        location.setId(51);
        location = locationRepository.save(location);

        stockId = StockId.builder()
                .idLocation(location.getId())
                .idProduct(product1.getId())
                .build();

        stockId2 = StockId.builder()
                .idLocation(location.getId())
                .idProduct(product2.getId())
                .build();

        stock1 = Stock.builder()
                .stockId(stockId)
                .product(product1)
                .location(location)
                .quantity(100)
                .build();
        stock1 = stockRepository.save(stock1);

        Stock stock2 = Stock.builder()
                .stockId(stockId2)
                .product(product2)
                .location(location)
                .quantity(50)
                .build();
        stock2 = stockRepository.save(stock2);

    }

    @Test(expected = RuntimeException.class)
    public void createOrder(){
        List<OrderDetailsDto> orderDetailsDtoList = new ArrayList<>();
        orderDetailsDtoList.add(
                OrderDetailsDto.builder()
                    .idOrder(51)
                    .idProduct(51)
                    .quantity(10)
                    .build()
        );
        orderDetailsDtoList.add(
                OrderDetailsDto.builder()
                        .idOrder(51)
                        .idProduct(52)
                        .quantity(45)
                        .build()
        );

        CustomerDto customerDto = CustomerDto.builder()
                .firstname("Andrei")
                .lastname("Brehuescu")
                .username("andre123")
                .password("123456789")
                .emailaddress("andrei@gmail.com")
                .build();
        customerDto.setId(1);

        OrderDto orderDto = OrderDto.builder()
                .detailsDtos(orderDetailsDtoList)
                .address(AddressDto.builder()
                        .addressStreetAddress("CustomerAddresTest")
                        .addressCity("CustomerAddresTest")
                        .addressCountry("CustomerAddresTest")
                        .addressCounty("CustomerAddresTest")
                        .build()
                )
                .customerDto(customerDto)
                .build();
        assert(orderService.addOrder(orderDto).isEmpty());
    }

    @Test
    public void createOrderTest(){
        List<OrderDetailsDto> orderDetailsDtoList = new ArrayList<>();
        orderDetailsDtoList.add(
                OrderDetailsDto.builder()
                        .idOrder(51)
                        .idProduct(product1.getId())
                        .quantity(10)
                        .build()
        );
        orderDetailsDtoList.add(
                OrderDetailsDto.builder()
                        .idOrder(51)
                        .idProduct(product2.getId())
                        .quantity(45)
                        .build()
        );

        CustomerDto customerDto = CustomerDto.builder()
                .firstname("Andrei")
                .lastname("Brehuescu")
                .username("andre123")
                .password("123456789")
                .emailaddress("andrei@gmail.com")
                .build();
        customerDto.setId(1);

        OrderDto orderDto = OrderDto.builder()
                .detailsDtos(orderDetailsDtoList)
                .address(AddressDto.builder()
                        .addressStreetAddress("CustomerAddresTest")
                        .addressCity("CustomerAddresTest")
                        .addressCountry("CustomerAddresTest")
                        .addressCounty("CustomerAddresTest")
                        .build()
                )
                .customerDto(customerDto)
                .build();
        assert(orderService.addOrder(orderDto).size()== 1);
    }


}
