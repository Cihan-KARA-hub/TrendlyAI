package com.kara.orderserver.services;

import com.kara.orderserver.api.dto.KafkaProductStockDto;
import com.kara.orderserver.api.dto.OrderAddDto;
import com.kara.orderserver.api.dto.OrderDto;
import com.kara.orderserver.repository.OrderItemsRepository;
import com.kara.orderserver.repository.OrdersRepository;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final KafkaTemplate kafkaTemplate;
    private  final OrdersRepository ordersRepository;
    private final OrderItemsRepository orderItemsRepository;

    public OrderServiceImpl(KafkaTemplate kafkaTemplate, OrdersRepository ordersRepository, OrderItemsRepository orderItemsRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.ordersRepository = ordersRepository;
        this.orderItemsRepository = orderItemsRepository;
    }

    @Override
    public OrderAddDto addOrder(OrderDto order) {
        //TODO  kafka istek at .. ok dönerse  sepete ekle
        //liste olarak  order itemleri gönderdim burdaki temler stoktan düşcek ve true  veya false dönecek
        KafkaProductStockDto kafkaProductStockDto = new KafkaProductStockDto(order.getItems());
        this.kafkaTemplate.send("prod.order.placed", kafkaProductStockDto);


        return null;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        return false;
    }

    @Override
    public OrderDto findOrderById(int orderId) {
        return null;
    }

    @Override
    public void updateOListOrder(Long OrderItemId, Long OrderId) {

    }

}
