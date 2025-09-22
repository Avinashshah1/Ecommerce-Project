package com.ecommerce.ecommerceProject.service;

import com.ecommerce.ecommerceProject.model.Product;
import com.ecommerce.ecommerceProject.payload.ProductDTO;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);
}
