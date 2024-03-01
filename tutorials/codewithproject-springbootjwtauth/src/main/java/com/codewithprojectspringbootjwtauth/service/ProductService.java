package com.codewithprojectspringbootjwtauth.service;

import com.codewithprojectspringbootjwtauth.dto.ProductRequest;
import com.codewithprojectspringbootjwtauth.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product createProduct(ProductRequest productRequest);
}
