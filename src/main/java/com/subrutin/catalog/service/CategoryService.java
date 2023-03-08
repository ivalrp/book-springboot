package com.subrutin.catalog.service;

import com.subrutin.catalog.domain.Category;
import com.subrutin.catalog.dto.CategoryCreateRequestDTO;
import com.subrutin.catalog.dto.CategoryListResponseDTO;
import com.subrutin.catalog.dto.ResultPageResponseDTO;

import java.util.List;

public interface CategoryService {

    public void createAndUpdateCategory(CategoryCreateRequestDTO dto);

    public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages, Integer limit,
                                                                           String sortBy, String direction, String categoryName);

    public List<Category> findCategories(List<String> categoryCodeList);

    public List<CategoryListResponseDTO> constructDTO(List<Category> categories);
}
