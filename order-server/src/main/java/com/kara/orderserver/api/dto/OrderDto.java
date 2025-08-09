package com.kara.orderserver.api.dto;

import com.kara.orderserver.entity.OrderItems;

import java.time.OffsetDateTime;
import java.util.List;

public class OrderDto {

    private Long userId;
    private OffsetDateTime orderDate;
    private Double totalPrice;
    private List<OrderItems> items;
    public OrderDto(Long userId, OffsetDateTime orderDate, Double totalPrice, List<OrderItems> items) {
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public OffsetDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(OffsetDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItems> getItems() {
        return items;
    }

    public void setItems(List<OrderItems> items) {
        this.items = items;
    }


}
