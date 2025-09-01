package com.ecommerce.ecommerceProject.controller;

import com.ecommerce.ecommerceProject.config.AppConstants;
import com.ecommerce.ecommerceProject.model.Category;
import com.ecommerce.ecommerceProject.payload.CategoryDTO;
import com.ecommerce.ecommerceProject.payload.CategoryResponseDTO;
import com.ecommerce.ecommerceProject.service.CategoryService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    // @GetMapping("/public/category")
    @RequestMapping(value = "/public/category", method = RequestMethod.GET)
    public ResponseEntity<CategoryResponseDTO> getCategoryList(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy",defaultValue = AppConstants.SORT_CATEGORIES_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder",defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder) {
        CategoryResponseDTO categoryResponseDTO = categoryService.getAllCategory(pageNumber, pageSize,sortBy,sortOrder);
        return new ResponseEntity<>(categoryResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/public/category")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categorydto) {
        CategoryDTO savedCategoryDTO = categoryService.createCategory(categorydto);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("api/public/category/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategoryList(@PathVariable Long categoryId) {
        CategoryDTO deleteCategory = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(deleteCategory, HttpStatus.OK);
    }

    @PutMapping("api/public/category/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Long categoryId) {

        CategoryDTO savedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);


    }


}
