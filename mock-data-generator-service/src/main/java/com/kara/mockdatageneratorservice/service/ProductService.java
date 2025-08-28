package com.kara.mockdatageneratorservice.service;

import com.kara.mockdatageneratorservice.controller.ProductController;
import com.kara.mockdatageneratorservice.entity.ProductCreateDto;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final FakeProduct fakeProduct;
    private final ProductController productController;

    public ProductService(FakeProduct fakeProduct, ProductController productController) {
        this.fakeProduct = fakeProduct;
        this.productController = productController;
    }
    @Scheduled(fixedRate = 5000)
    public void generateAndSendProduct() {
        try {
            ProductCreateDto fake = fakeProduct.generateProduct();
            productController.createProduct(fake);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
