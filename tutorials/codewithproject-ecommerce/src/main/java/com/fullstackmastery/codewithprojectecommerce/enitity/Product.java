package com.fullstackmastery.codewithprojectecommerce.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fullstackmastery.codewithprojectecommerce.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;
    @Lob
    private String description;
    @Lob
    private byte[] image;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="category_id",nullable = false)
    @JsonIgnore
    private Category category;

    public ProductDTO getDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(id);
        productDTO.setName(name);
        productDTO.setDescription(description);
        productDTO.setPrice(price);
        productDTO.setByteImage(image);
        productDTO.setCategoryId(category.getId());
        return productDTO;
    }
}
