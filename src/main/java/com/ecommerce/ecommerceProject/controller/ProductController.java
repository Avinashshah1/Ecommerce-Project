package com.ecommerce.ecommerceProject.controller;

import com.ecommerce.ecommerceProject.model.Product;
import com.ecommerce.ecommerceProject.payload.ProductDTO;
import com.ecommerce.ecommerceProject.payload.ProductResponse;
import com.ecommerce.ecommerceProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/admin/categories/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO,
                                                 @PathVariable Long categoryId)
    {
        ProductDTO savedProductDTO=  productService.addProduct(categoryId,productDTO);
        return  new ResponseEntity<>(savedProductDTO, HttpStatus.CREATED);
    }

    @GetMapping("/public/products")
    public ResponseEntity<ProductResponse>getAllProducts()
    {
        ProductResponse productResponse=productService.getAllProducts();
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

    @GetMapping("/public/categories/{categoryId}/products")
    public ResponseEntity<ProductResponse>getProductsByCategory(@PathVariable Long categoryId)
    {
        ProductResponse productResponse=productService.searchByCategory(categoryId);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }
 @GetMapping("/public/products/keyword/{keywords}")
    public ResponseEntity<ProductResponse>getProductsByKeyword(@PathVariable String keyword)
 {
     ProductResponse productResponse=productService.searchProductByKeyword(keyword);
     return new ResponseEntity<>(productResponse,HttpStatus.FOUND);
 }

 @PutMapping("/api/products/{productId}")
    public ResponseEntity<ProductDTO> updateProducts(@PathVariable Long productId,@RequestBody ProductDTO productDTO)
 {
     ProductDTO updatedProductDTO=productService.updateProducts(productId,productDTO);
     return new ResponseEntity<>(updatedProductDTO,HttpStatus.OK);
 }

 @PutMapping("/products/{productId}/image")
    public ResponseEntity<ProductDTO> updateProductImage(@PathVariable Long productId,
                                                         @RequestParam("Image")MultipartFile image) throws IOException {
     ProductDTO updatedProduct=productService.updateProductImage(productId,image);
     return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
 }

}
