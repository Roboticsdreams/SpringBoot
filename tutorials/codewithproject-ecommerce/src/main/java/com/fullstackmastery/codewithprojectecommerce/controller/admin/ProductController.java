package com.fullstackmastery.codewithprojectecommerce.controller.admin;

import com.fullstackmastery.codewithprojectecommerce.dto.CategoryDTO;
import com.fullstackmastery.codewithprojectecommerce.dto.ProductDTO;
import com.fullstackmastery.codewithprojectecommerce.enitity.Category;
import com.fullstackmastery.codewithprojectecommerce.enitity.Product;
import com.fullstackmastery.codewithprojectecommerce.services.admin.category.CategoryService;
import com.fullstackmastery.codewithprojectecommerce.services.admin.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@ModelAttribute ProductDTO productDTO) throws IOException {
        Product product = productService.addProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> productDTOs = productService.getAllProducts();
        return ResponseEntity.ok(productDTOs);
    }
}
