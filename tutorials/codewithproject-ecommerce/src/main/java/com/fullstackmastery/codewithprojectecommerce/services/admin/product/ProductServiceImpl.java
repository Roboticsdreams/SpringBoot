package com.fullstackmastery.codewithprojectecommerce.services.admin.product;

import com.fullstackmastery.codewithprojectecommerce.dto.ProductDTO;
import com.fullstackmastery.codewithprojectecommerce.enitity.Category;
import com.fullstackmastery.codewithprojectecommerce.enitity.Product;
import com.fullstackmastery.codewithprojectecommerce.repository.CategoryRepository;
import com.fullstackmastery.codewithprojectecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product addProduct(ProductDTO productDTO) throws IOException {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage().getBytes());

        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow();
        return productRepository.save(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(Product::getDTO).collect(Collectors.toList());
    }
}
