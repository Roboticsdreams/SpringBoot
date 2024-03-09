package com.codewithprojectsrefreshtokenauth.controller;

import com.codewithprojectsrefreshtokenauth.entity.Product;
import com.codewithprojectsrefreshtokenauth.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{productId}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getProductById(@PathVariable  Long productId) {
        try {
            Product product = productService.getProductById(productId).orElseThrow(
                    () -> new RuntimeException("product not found for id ::" + productId)
            );
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/product")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}
