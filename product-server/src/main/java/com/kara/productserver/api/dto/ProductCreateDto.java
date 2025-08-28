package com.kara.productserver.api.dto;

public class ProductCreateDto {
    private String name;
    private int stock_quantity;
    private String barcode;
    private double price;
    private String categoryName;

    public ProductCreateDto(String name, int stock_quantity, String barcode, double price, String categoryName) {
        this.name = name;
        this.stock_quantity = stock_quantity;
        this.barcode = barcode;
        this.price = price;
        this.categoryName = categoryName;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
