package com.ecommerce.ecommerceProject.service;

import com.ecommerce.ecommerceProject.exceptions.APIException;
import com.ecommerce.ecommerceProject.exceptions.ResourceNotFoundException;
import com.ecommerce.ecommerceProject.model.Category;
import com.ecommerce.ecommerceProject.payload.CategoryDTO;
import com.ecommerce.ecommerceProject.payload.CategoryResponseDTO;
import com.ecommerce.ecommerceProject.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Category category;

    @Override
    public CategoryResponseDTO getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty())

            throw new APIException("No category created till now");

        List<CategoryDTO> categoryDTOS = categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();

        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setContent(categoryDTOS);
        return categoryResponseDTO;

    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categorydto) {
       Category category=modelMapper.map(categorydto,Category.class);
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null) {
            throw new APIException("Category with the name" + categorydto.getCategoryName() + "already exists");
        }

       Category savedNewCategory=categoryRepository.save(category);
        return modelMapper.map(savedNewCategory,CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
  CategoryDTO categoryDTO= modelMapper.map(category,CategoryDTO.class);
        categoryRepository.delete(category);
        return categoryDTO;
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {

        Optional<Category> categoryList = categoryRepository.findById(categoryId);
        Category savedCategory = categoryList.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        Category category=modelMapper.map(categoryDTO,Category.class);
        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory,CategoryDTO.class);

    }


}
