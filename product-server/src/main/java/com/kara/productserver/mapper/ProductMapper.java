package com.kara.productserver.mapper;

import com.kara.productserver.api.dto.ProductCreateDto;
import com.kara.productserver.api.dto.ProductDto;
import com.kara.productserver.api.dto.ProductUpdateDto;
import com.kara.productserver.entity.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProductMapper {

    public List<ProductDto> productsToDto(Page<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            productDto.setPrice(product.getPrice());
            productDto.setName(product.getName());
            productDto.setCategoryId(product.getCategory());
            productDto.setBarcode(product.getBarcode());
            productDto.setCreated_at(product.getCreated_at());
            productDto.setUpdated_at(product.getUpdated_at());
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public Product productDtoToProduct(ProductCreateDto productDto, int categoryId) {
        Product product = new Product();
        product.setStock_quantity(productDto.getStock_quantity());
        product.setName(productDto.getName());
        product.setCategory(categoryId);
        product.setBarcode(productDto.getBarcode());
        product.setPrice(productDto.getPrice());
        return product;
    }

    public void update(Product entity, ProductUpdateDto dto) {
        try {
            for (Field dtoField : dto.getClass().getDeclaredFields()) {
                dtoField.setAccessible(true);
                Object value = dtoField.get(dto);

                if (value != null) {
                    try {
                        Field entityField = entity.getClass().getDeclaredField(dtoField.getName());
                        entityField.setAccessible(true);
                        entityField.set(entity, value);
                    } catch (NoSuchFieldException ignored) {
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Mapping sırasında hata oluştu", e);
        }
    }
}
