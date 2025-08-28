package com.kara.orderserver.api.dto;

import java.util.List;

public class OrderAddDto {
    private Long userId;
    private List<AddOrderItemsDto> items;

    public OrderAddDto() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<AddOrderItemsDto> getItems() {
        return items;
    }

    public void setItems(List<AddOrderItemsDto> items) {
        this.items = items;
    }
}
