package com.kara.orderserver.api.dto;

import com.kara.orderserver.entity.OrderItems;

import java.util.List;

public class OrderAddDto {
    private Long userId;
    private List<OrderItems> items;
    public OrderAddDto(Long userId, List<OrderItems> items) {
        this.userId = userId;
        this.items = items;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderItems> getItems() {
        return items;
    }

    public void setItems(List<OrderItems> items) {
        this.items = items;
    }


}
