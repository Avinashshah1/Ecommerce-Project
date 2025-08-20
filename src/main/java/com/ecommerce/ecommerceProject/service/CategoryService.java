package com.ecommerce.ecommerceProject.service;

import com.ecommerce.ecommerceProject.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category>getAllCategory();
    void createCategory(Category category);

    String deleteCategory(Long categoryId);
    Category updateCategory(Category category,Long categoryId);


}
