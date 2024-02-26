package com.fullstackmastery.codewithprojectecommerce.controller.admin;

import com.fullstackmastery.codewithprojectecommerce.dto.CategoryDTO;
import com.fullstackmastery.codewithprojectecommerce.enitity.Category;
import com.fullstackmastery.codewithprojectecommerce.services.admin.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryDTO){
        System.out.println("Post mapping category");
        Category category = categoryService.createCategory(categoryDTO);
        System.out.println("category "+category.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
