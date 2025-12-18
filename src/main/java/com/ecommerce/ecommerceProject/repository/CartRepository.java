package com.ecommerce.ecommerceProject.repository;

import com.ecommerce.ecommerceProject.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
