package com.ecommerce.ecommerceProject.service;

import com.ecommerce.ecommerceProject.model.Category;
import com.ecommerce.ecommerceProject.payload.CategoryDTO;
import com.ecommerce.ecommerceProject.payload.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO getAllCategory();
    CategoryDTO createCategory(CategoryDTO categoryDto);

    CategoryDTO deleteCategory(Long categoryId);
    CategoryDTO updateCategory(CategoryDTO categoryDTO,Long categoryId);


}
