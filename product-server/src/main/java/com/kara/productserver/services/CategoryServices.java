package com.kara.productserver.services;

import com.kara.productserver.entity.Category;
import com.kara.productserver.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {
    private final CategoryRepository categoryRepository;


    public CategoryServices(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void addCategory(String categoryName) {
        Category ct = new Category();
        ct.setName(categoryName);
        categoryRepository.save(ct);
    }
}
