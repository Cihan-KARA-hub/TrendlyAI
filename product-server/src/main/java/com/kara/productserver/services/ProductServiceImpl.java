package com.kara.productserver.services;

import com.kara.productserver.api.dto.KafkaProductStockDto;
import com.kara.productserver.api.dto.ProductCreateDto;
import com.kara.productserver.api.dto.ProductDto;
import com.kara.productserver.api.dto.ProductUpdateDto;
import com.kara.productserver.entity.Category;
import com.kara.productserver.entity.Product;
import com.kara.productserver.mapper.ProductMapper;
import com.kara.productserver.repository.CategoryRepository;
import com.kara.productserver.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service

public class ProductServiceImpl implements ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);


    public ProductServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository, ProductMapper productMapper) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    @Override
    public List<ProductDto> listProduct(String category, Pageable pageable) {
        Category category1 = categoryRepository.findByName(category);
        Page<Product> products = productRepository.findByCategory(category1.getId(), pageable);
        return productMapper.productsToDto(products);
    }

    @Override
    public void addProduct(ProductCreateDto product) {
        Category category = categoryRepository.findByName(product.getCategoryName());
        if (category == null) {
            category = new Category();
            category.setName(product.getCategoryName());
            category = categoryRepository.save(category);
        }
        Product product1 = productMapper.productDtoToProduct(product, category.getId());
        productRepository.save(product1);
    }

    @Override
    public void updateProduct(ProductUpdateDto productDto, UUID productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productMapper.update(product, productDto);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID product) {
        productRepository.deleteById(product);
    }

    @Override
    public void decrementStock(UUID id, int quantity) {
        productRepository.decrementStockByUuidIfAvailable(id, quantity);
    }

    @Override
    @KafkaListener(topics = "prod.order.placed", groupId = "my_consumer_group")
    public void deIncrementStock(List<KafkaProductStockDto> message) {
        message.forEach(stock -> {
            logger.error("Gelen ürün id: " + stock.getId() +
                    " - adet: " + stock.getStockCount());
            //todo veri tabanı de icremet
            productRepository.decrementStockByUuidIfAvailable(stock.getId(), stock.getStockCount());
        });
    }
    // ilgili id'nin stock kontrolünü yap stok varsa tre döndür .

}
