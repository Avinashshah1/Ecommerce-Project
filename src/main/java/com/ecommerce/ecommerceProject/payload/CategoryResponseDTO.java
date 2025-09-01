package com.ecommerce.ecommerceProject.payload;

import lombok.Data;

import java.util.List;
@Data
public class CategoryResponseDTO {


    private List<CategoryDTO> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalpages;
    private boolean lastPage;
    public List<CategoryDTO> getContent() {
        return content;
    }

    public void setContent(List<CategoryDTO> content) {
        this.content = content;
    }


}
