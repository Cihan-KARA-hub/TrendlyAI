package com.kara.productserver.api.dto;


import java.time.OffsetDateTime;


public class ProductUpdateDto {
    private String name;
    private int stock_quantity;
    private String barcode;
    private double price;
    private int categoryId;
    private OffsetDateTime updated_at;


    public ProductUpdateDto(String name, int stock_quantity, String barcode, double price, int categoryId, OffsetDateTime updated_at) {
        this.name = name;
        this.stock_quantity = stock_quantity;
        this.barcode = barcode;
        this.price = price;
        this.categoryId = categoryId;
        this.updated_at = updated_at;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public OffsetDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(OffsetDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
