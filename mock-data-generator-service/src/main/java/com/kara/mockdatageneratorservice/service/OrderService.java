package com.kara.mockdatageneratorservice.service;

import com.kara.mockdatageneratorservice.controller.OrderController;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final FakeOrder fakeOrder;
    private final OrderController orderController;

    public OrderService(FakeOrder fakeOrder, OrderController orderController) {
        this.fakeOrder = fakeOrder;
        this.orderController = orderController;
    }
    @Scheduled(fixedRate = 5000)
    public void postOrder() {
        orderController.createOrder(fakeOrder.generateOrder());
    }
}
