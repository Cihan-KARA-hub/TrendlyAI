package com.kara.orderserver.mapper;

import com.kara.orderserver.api.dto.KafkaProductStockDto;
import com.kara.orderserver.api.dto.OrdersDto;
import com.kara.orderserver.entity.OrderItems;
import com.kara.orderserver.entity.Orders;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OrderMapper {

    public List<KafkaProductStockDto> kafkaMapper(List<OrderItems> items) {
        List<KafkaProductStockDto> dtos = new ArrayList<>();
        items.forEach(item -> {
            KafkaProductStockDto dto = new KafkaProductStockDto();
            dto.setId(item.getProductUuid());
            dto.setStockCount(item.getQuantity());
            dtos.add(dto);
        });
        return dtos;
    }


   public OrdersDto toDto(Orders order) {
        OrdersDto dto = new OrdersDto();
        dto.setId(order.getId());
        dto.setItems(order.getItems());
        dto.setOrderDate(order.getOrderDate());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setUserId(order.getUserId());
        dto.setCreatedAt(order.getCreatedAt());
        dto.setUpdatedAt(order.getUpdatedAt());
        return dto;
    }
}
