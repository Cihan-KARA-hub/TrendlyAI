package com.kara.orderserver.api.dto;

import com.kara.orderserver.entity.Orders;

import java.util.UUID;

public class AddOrderItemsDto {
    private Orders order;
    private UUID productUuid;
    private int quantity;
    private double price;

    public AddOrderItemsDto() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public UUID getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(UUID productUuid) {
        this.productUuid = productUuid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
