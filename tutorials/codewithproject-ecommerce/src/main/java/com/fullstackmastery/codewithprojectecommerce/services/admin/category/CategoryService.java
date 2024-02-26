package com.fullstackmastery.codewithprojectecommerce.services.admin.category;

import com.fullstackmastery.codewithprojectecommerce.dto.CategoryDTO;
import com.fullstackmastery.codewithprojectecommerce.enitity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryDTO categoryDTO);
    List<Category> getAllCategories();
}
