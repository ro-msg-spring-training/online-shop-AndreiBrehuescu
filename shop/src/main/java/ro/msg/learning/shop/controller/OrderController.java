package ro.msg.learning.shop.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.service.interfaces.IOrder;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final IOrder orderService;

    @GetMapping("/orders")
    public List<OrderDto> getOrder(){
        return this.orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public OrderDto getOrder(@PathVariable Integer id){
        Optional<OrderDto> orderDto = this.orderService.getOrderById(id);

        if(orderDto.isEmpty()){
            return null;
        }

        return orderDto.get();
    }


    @PostMapping(value = "/orders")
    public ResponseEntity<Object> addOrder(@RequestBody OrderDto orderDto){
        this.orderService.addOrder(orderDto);

        return new ResponseEntity<>("Order added", HttpStatus.CREATED);
    }


    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Integer id){
        this.orderService.deleteOrderById(id);

        //return new ResponseEntity<>("Order deleted", HttpStatus.CREATED);
        return;
    }

}
