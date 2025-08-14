package com.kara.orderserver.api.controller;

import com.kara.orderserver.api.dto.OrderAddDto;
import com.kara.orderserver.api.dto.OrdersDto;
import com.kara.orderserver.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("add-order")
    @ResponseStatus(HttpStatus.OK)
    public void addOrder(@RequestBody OrderAddDto order) {
        orderService.addOrder(order);
    }

    @GetMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public OrdersDto findOrderById(@PathVariable Long orderId) {
        return orderService.findOrderById(orderId);
    }


    @DeleteMapping("delete-item/{orderItemId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable("orderItemId") Long orderItemId) {
        orderService.orderItemDelete(orderItemId);
    }

    @DeleteMapping("delete-order/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        orderService.deleteOrder(orderId);
    }


}
