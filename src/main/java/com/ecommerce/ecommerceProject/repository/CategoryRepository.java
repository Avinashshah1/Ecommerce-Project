package com.ecommerce.ecommerceProject.repository;

import com.ecommerce.ecommerceProject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByCategoryName(String categoryName);

}
