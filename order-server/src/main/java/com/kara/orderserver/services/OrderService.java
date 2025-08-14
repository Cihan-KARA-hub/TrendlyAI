package com.kara.orderserver.services;


import com.kara.orderserver.api.dto.OrderAddDto;
import com.kara.orderserver.api.dto.OrdersDto;

public interface OrderService {
    // sipariş oluştma
    void addOrder(OrderAddDto order);

    void deleteOrder(Long orderId);

    OrdersDto findOrderById(Long orderId);

    void orderItemDelete(Long orderItemId);


}
