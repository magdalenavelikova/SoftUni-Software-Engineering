package com.example.json.service;

import com.example.json.model.dto.CategoryProductsSummaryDto;
import com.example.json.model.entity.Category;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    void importCategories() throws IOException;

    Set<Category> randomSetOfCategories();

    List<CategoryProductsSummaryDto> categoriesByProductsCount();
}
