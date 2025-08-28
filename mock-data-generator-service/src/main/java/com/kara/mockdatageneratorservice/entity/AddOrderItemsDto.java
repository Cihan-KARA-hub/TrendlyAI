package com.kara.mockdatageneratorservice.entity;

import java.util.UUID;

public class AddOrderItemsDto {
    // private Orders order;
    private UUID productUuid;
    private int quantity;
    private double price;

    public AddOrderItemsDto() {
    }

    public AddOrderItemsDto(UUID productUuid, int quantity, double price) {
        this.productUuid = productUuid;
        this.quantity = quantity;
        this.price = price;
    }

    public UUID getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(UUID productUuid) {
        this.productUuid = productUuid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
