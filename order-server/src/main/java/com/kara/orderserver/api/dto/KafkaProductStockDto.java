package com.kara.orderserver.api.dto;

import com.kara.orderserver.entity.OrderItems;

import java.util.List;

public class KafkaProductStockDto {
    private List<OrderItems> orderItems;

    public KafkaProductStockDto(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }
}
