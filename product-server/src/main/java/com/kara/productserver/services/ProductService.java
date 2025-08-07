package com.kara.productserver.services;

import com.kara.productserver.api.dto.ProductDto;
import com.kara.productserver.api.dto.ProductUpdateDto;
import com.kara.productserver.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductDto> listProduct(String category, Pageable pageable);

    void addProduct(ProductDto product);

    void updateProduct(ProductUpdateDto product, UUID productId);

    void deleteProduct(UUID product);

    void decrementStock(UUID id);
}
