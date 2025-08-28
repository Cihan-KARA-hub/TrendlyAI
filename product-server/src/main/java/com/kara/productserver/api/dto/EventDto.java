package com.kara.productserver.api.dto;

import java.util.List;

public class EventDto {
    private List<KafkaProductStockDto> kafkaProductStockDtos;

    public List<KafkaProductStockDto> getKafkaProductStockDtos() {
        return kafkaProductStockDtos;
    }

    public void setKafkaProductStockDtos(List<KafkaProductStockDto> kafkaProductStockDtos) {
        this.kafkaProductStockDtos = kafkaProductStockDtos;
    }
}
