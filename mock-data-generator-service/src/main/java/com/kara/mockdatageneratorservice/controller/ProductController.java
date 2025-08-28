package com.kara.mockdatageneratorservice.controller;

import com.kara.mockdatageneratorservice.entity.ProductCreateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "create-product", url = "http://localhost:8082/products")
public interface ProductController {

    @RequestMapping(method = RequestMethod.POST, value = "/add", produces = "application/json")
    void createProduct(@RequestBody ProductCreateDto product);

}