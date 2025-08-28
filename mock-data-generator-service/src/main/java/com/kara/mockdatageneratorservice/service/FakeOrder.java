package com.kara.mockdatageneratorservice.service;

import com.kara.mockdatageneratorservice.entity.AddOrderItemsDto;
import com.kara.mockdatageneratorservice.entity.OrderAddDto;
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
    private final List<AddOrderItemsDto> orderItemsList = new ArrayList<>();
    private final Random rand = new Random();
    OffsetDateTime tine = OffsetDateTime.now();

    private AddOrderItemsDto generateOrderItem() {
        return new AddOrderItemsDto(
                UUID.fromString("9ed0ba9b-422d-40a2-b720-0afebb075765"),
                rand.nextInt(1, 10),
                rand.nextDouble(111, 30000)
        );
    }

    public OrderAddDto generateOrder() {
        orderItemsList.add(generateOrderItem());
        OrderAddDto dto = new OrderAddDto();
        dto.setItems(orderItemsList);
        dto.setUserId(rand.nextLong(1, 10));
        return dto;
    }
}
