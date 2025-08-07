package com.kara.productserver.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity

@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Column(name = "stock_quantity", nullable = false)
    private int stock_quantity;
    @Column(name = "barcode", nullable = false, length = 8)
    private String barcode;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "category_id", nullable = false, length = 50)
    private int category;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime created_at;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updated_at;

    public Product(UUID id, String name, int stock_quantity, String barcode, double price, int category, OffsetDateTime created_at, OffsetDateTime updated_at) {
        this.id = id;
        this.name = name;
        this.stock_quantity = stock_quantity;
        this.barcode = barcode;
        this.price = price;
        this.category = category;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Product() {

    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = Math.max(stock_quantity, 0);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
        this.price = Math.max(price, 0.99);
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public OffsetDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(OffsetDateTime created_at) {
        this.created_at = created_at;
    }

    public OffsetDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(OffsetDateTime updated_at) {
        this.updated_at = updated_at;
    }


}


