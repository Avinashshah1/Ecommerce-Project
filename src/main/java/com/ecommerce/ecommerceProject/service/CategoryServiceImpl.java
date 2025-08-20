package com.ecommerce.ecommerceProject.service;

import com.ecommerce.ecommerceProject.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    Long id = 1L;
    private List<Category> categoryList = new ArrayList<>();

    @Override
    public List<Category> getAllCategory() {
        return categoryList;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(id++);
        categoryList.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {

        Category category = categoryList.stream()
                .filter(category1 -> category1.getCategoryId().equals(categoryId))
                .findFirst().
                orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"resource not found"));
        if(category==null)
            return null;
        categoryList.remove(category);
        return "Category with category id" + categoryId + "deleted successfully";

    }
}
