package com.codewithprojectsrefreshtokenauth.service.impl;

import com.codewithprojectsrefreshtokenauth.entity.Product;
import com.codewithprojectsrefreshtokenauth.repository.ProductRepository;
import com.codewithprojectsrefreshtokenauth.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public Optional<Product> getProductById (Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public List<Product> getAllProducts () {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct (Product product) {
        return productRepository.save(product);
    }
}
