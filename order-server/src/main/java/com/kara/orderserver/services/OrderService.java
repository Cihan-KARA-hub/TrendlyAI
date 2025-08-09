package com.kara.orderserver.services;


import com.kara.orderserver.api.dto.OrderAddDto;
import com.kara.orderserver.api.dto.OrderDto;

public interface OrderService {
    // sipariş oluştma
    OrderAddDto addOrder(OrderDto order);

    boolean deleteOrder(int orderId);

    OrderDto findOrderById(int orderId);

    // liste güncelleme
    void updateOListOrder(Long OrderItemId, Long OrderId);


}
