package com.kara.productserver.services;

import com.kara.productserver.api.dto.*;
import com.kara.productserver.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductDto> listProduct(String category, Pageable pageable);

    void addProduct(ProductCreateDto product);

    void updateProduct(ProductUpdateDto product, UUID productId);

    void deleteProduct(UUID product);

    void decrementStock(UUID id,int quantity);

    void deIncrementStock(List<KafkaProductStockDto>  message);
}
