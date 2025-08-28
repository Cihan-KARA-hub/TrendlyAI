package com.kara.mockdatageneratorservice.service;

import com.kara.mockdatageneratorservice.entity.OrderItemsDto;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class FakeOrder {
    private final Faker faker = new Faker();
    private final List<OrderItemsDto> orderItemsList = new ArrayList<>();
    private final Random rand = new Random();
    OffsetDateTime tine = OffsetDateTime.now();

    public void generateOrder() {

    }
}
