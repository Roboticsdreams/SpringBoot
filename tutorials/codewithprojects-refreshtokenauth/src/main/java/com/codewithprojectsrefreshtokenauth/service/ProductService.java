package com.codewithprojectsrefreshtokenauth.service;

import com.codewithprojectsrefreshtokenauth.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById(Long productId);
    List<Product> getAllProducts();
    Product saveProduct(Product product);
}
