package com.fullstackmastery.codewithprojectecommerce.services.admin.product;

import com.fullstackmastery.codewithprojectecommerce.dto.ProductDTO;
import com.fullstackmastery.codewithprojectecommerce.enitity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    Product addProduct(ProductDTO productDTO) throws IOException;

    List<ProductDTO> getAllProducts();
}
