package com.kara.productserver.services;

import com.kara.productserver.api.dto.ProductDto;
import com.kara.productserver.api.dto.ProductUpdateDto;
import com.kara.productserver.entity.Category;
import com.kara.productserver.entity.Product;
import com.kara.productserver.mapper.ProductMapper;
import com.kara.productserver.repository.CategoryRepository;
import com.kara.productserver.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ProductServiceImpl implements ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private  ProductMapper productMapper;

    public ProductServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;


    }


    @Override
    public List<ProductDto> listProduct(String category, Pageable pageable) {
        Category category1 = categoryRepository.findByName(category);
        Page<Product> products = productRepository.findByCategory(category1.getId(), pageable);
        return productMapper.productsToDto(products);
    }

    @Override
    public void addProduct(ProductDto product) {
        Product product1 = productMapper.productDtoToProduct(product);
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
    public void decrementStock(UUID id) {
        productRepository.decrementStockByUuidIfAvailable(id);
    }
}
