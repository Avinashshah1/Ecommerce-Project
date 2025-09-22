package com.ecommerce.ecommerceProject.repository;

import com.ecommerce.ecommerceProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
