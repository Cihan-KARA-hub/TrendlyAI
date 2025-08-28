package com.kara.productserver.api.dto;

import java.util.UUID;

public class KafkaProductStockDto {
    private UUID id;
    private int stockCount;

    public KafkaProductStockDto(UUID id, int stockCount) {
        this.id = id;
        this.stockCount = stockCount;
    }

    public KafkaProductStockDto() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }
}
