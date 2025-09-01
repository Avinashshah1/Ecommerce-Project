package com.ecommerce.ecommerceProject.payload;

import java.util.List;

public class CategoryResponseDTO {
    public List<CategoryDTO> getContent() {
        return content;
    }

    public void setContent(List<CategoryDTO> content) {
        this.content = content;
    }

    private List<CategoryDTO> content;
}
