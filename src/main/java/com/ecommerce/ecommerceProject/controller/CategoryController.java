package com.ecommerce.ecommerceProject.controller;

import com.ecommerce.ecommerceProject.model.Category;
import com.ecommerce.ecommerceProject.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    @GetMapping("api/public/category")
    public ResponseEntity<List<Category>> getCategoryList()
    {
        List<Category> status=categoryService.getAllCategory();
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @PostMapping("api/public/category")
    public ResponseEntity<String> setCategoryList(@RequestBody Category category)
    {
       categoryService.createCategory(category);
        return new ResponseEntity<>("category is filled",HttpStatus.CREATED);
    }

    @DeleteMapping("api/public/category/{categoryId}")
    public ResponseEntity<String> deleteCategoryList(@PathVariable Long categoryid)
    {
       try{
           String status=categoryService.deleteCategory(categoryid);
           return new ResponseEntity<>(status, HttpStatus.OK);
       }
       catch(ResponseStatusException e)
       {
           return new ResponseEntity<>(e.getMessage(),e.getStatusCode());
       }

    }
    @PutMapping("api/public/category")
    public ResponseEntity<String>updateCategory(@ResponseBody Category category)

}
