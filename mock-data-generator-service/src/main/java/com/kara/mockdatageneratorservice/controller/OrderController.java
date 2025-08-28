package com.kara.mockdatageneratorservice.controller;

import com.kara.mockdatageneratorservice.entity.OrderAddDto;
import com.kara.mockdatageneratorservice.entity.ProductCreateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "order-service",url = "http://localhost:8083/")
public interface OrderController {
    @RequestMapping(method = RequestMethod.POST, value = "/add-order", produces = "application/json")
    void createOrder(@RequestBody OrderAddDto orderAddDto);
}
