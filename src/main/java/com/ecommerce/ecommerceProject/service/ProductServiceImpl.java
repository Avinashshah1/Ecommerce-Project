package com.ecommerce.ecommerceProject.service;

import com.ecommerce.ecommerceProject.exceptions.ResourceNotFoundException;
import com.ecommerce.ecommerceProject.model.Category;
import com.ecommerce.ecommerceProject.model.Product;
import com.ecommerce.ecommerceProject.payload.ProductDTO;
import com.ecommerce.ecommerceProject.repository.CategoryRepository;
import com.ecommerce.ecommerceProject.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ProductDTO addProduct(Long categoryId, Product product) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        product.setCategory(category);
        product.setImage("default.png");
        double specialPrice=product.getPrice()-((product.getDiscount()/100)* product.getPrice());
        product.setSpecialPrice(specialPrice);
        Product savedProduct=productRepository.save(product);
        return modelMapper.map(savedProduct,ProductDTO.class);
    }
}
