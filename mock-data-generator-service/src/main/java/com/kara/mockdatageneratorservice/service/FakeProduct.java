package com.kara.mockdatageneratorservice.service;

import com.kara.mockdatageneratorservice.entity.ProductCreateDto;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FakeProduct {
    private final Faker faker = new Faker();

    private final Random rand = new Random();

    public ProductCreateDto generateProduct() {
        ProductCreateDto productCreateDto = new ProductCreateDto();
        productCreateDto.setName(faker.commerce().productName());
        productCreateDto.setPrice(Double.parseDouble(faker.commerce().price(50, 50000)));
        productCreateDto.setStock_quantity(rand.nextInt(10, 1000));
        productCreateDto.setBarcode(String.valueOf(rand.nextInt(10000000)));
        productCreateDto.setCategoryName(faker.commerce().department());
        return productCreateDto;
    }
}
