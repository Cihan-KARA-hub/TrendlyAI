package com.kara.orderserver.services;

import com.kara.orderserver.api.dto.KafkaProductStockDto;
import com.kara.orderserver.api.dto.OrderAddDto;
import com.kara.orderserver.api.dto.OrdersDto;
import com.kara.orderserver.entity.Orders;
import com.kara.orderserver.mapper.OrderMapper;
import com.kara.orderserver.repository.OrderItemsRepository;
import com.kara.orderserver.repository.OrdersRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final KafkaTemplate kafkaTemplate;
    private final OrdersRepository ordersRepository;
    private final OrderMapper orderMapper;
    private final OrderItemsRepository orderItemsRepository;


    public OrderServiceImpl(KafkaTemplate kafkaTemplate, OrdersRepository ordersRepository, OrderMapper orderMapper, OrderItemsRepository orderItemsRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.ordersRepository = ordersRepository;
        this.orderMapper = orderMapper;
        this.orderItemsRepository = orderItemsRepository;
    }

    @Override
    @Transactional
    public void addOrder(OrderAddDto order) {
        List<KafkaProductStockDto> kafkaDto = orderMapper.kafkaMapper(order.getItems());
        this.kafkaTemplate.send("prod.order.placed","stockDeIncrement",kafkaDto);
        Orders orders = new Orders();
        orders.setItems(order.getItems());
        order.getItems().forEach(orderItems -> {
            orders.setTotalPrice(orderItems.getPrice() + orders.getTotalPrice());
        });
        orders.setUserId(order.getUserId());
        ordersRepository.save(orders);
    }
    @Override
    public void deleteOrder(Long orderId) {
         ordersRepository.deleteById(orderId);
    }

    @Override
    public OrdersDto findOrderById(Long orderId) {
        Optional<Orders> orders = Optional.of(ordersRepository.findById(orderId).orElseThrow());
        return orderMapper.toDto(orders.get());
    }
    @Override
    public void orderItemDelete(Long orderItemId) {
        orderItemsRepository.deleteById(orderItemId);
    }

}
