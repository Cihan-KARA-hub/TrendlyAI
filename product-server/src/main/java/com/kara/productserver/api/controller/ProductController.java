package com.kara.productserver.api.controller;

import com.kara.productserver.api.dto.ProductCreateDto;
import com.kara.productserver.api.dto.ProductDto;
import com.kara.productserver.api.dto.ProductUpdateDto;
import com.kara.productserver.services.CategoryServices;
import com.kara.productserver.services.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryServices categoryServices;

    public ProductController(ProductService productService, CategoryServices categoryServices) {
        this.productService = productService;
        this.categoryServices = categoryServices;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(@RequestParam String categoryName,
                                                        @RequestParam int page,
                                                        @RequestParam int size) {
        Pageable pages = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.listProduct(categoryName, pages));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<HttpStatusCode> updateProduct(@RequestBody ProductUpdateDto productDto, @PathVariable UUID id) {
        productService.updateProduct(productDto, id);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatusCode> createProduct(@RequestBody ProductCreateDto productCreateDto) {
        productService.addProduct(productCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<HttpStatusCode> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(215).build();
    }

    @PutMapping("decrement-stock/{id}/{quantity}")
    public ResponseEntity<HttpStatusCode> decrementStock(@PathVariable UUID id, @PathVariable int quantity) {
        productService.decrementStock(id, quantity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("add-category")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategory(@RequestParam String name) {
        categoryServices.addCategory(name);
    }
}