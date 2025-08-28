package com.kara.mockdatageneratorservice.entity;

import java.util.List;

public class OrderAddDto {
    private Long userId;
    private List<AddOrderItemsDto> items;

    public OrderAddDto() {
    }

    public List<AddOrderItemsDto> getItems() {
        return items;
    }

    public void setItems(List<AddOrderItemsDto> items) {
        this.items = items;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
