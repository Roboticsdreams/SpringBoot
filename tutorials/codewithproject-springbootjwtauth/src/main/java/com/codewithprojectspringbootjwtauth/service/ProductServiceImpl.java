package com.codewithprojectspringbootjwtauth.service;

import com.codewithprojectspringbootjwtauth.dto.ProductRequest;
import com.codewithprojectspringbootjwtauth.entity.Product;
import com.codewithprojectspringbootjwtauth.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        return productRepository.save(product);
    }
}