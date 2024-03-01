package com.codewithprojectspringbootjwtauth.controller;

import com.codewithprojectspringbootjwtauth.dto.ProductRequest;
import com.codewithprojectspringbootjwtauth.entity.Product;
import com.codewithprojectspringbootjwtauth.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Product createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

}