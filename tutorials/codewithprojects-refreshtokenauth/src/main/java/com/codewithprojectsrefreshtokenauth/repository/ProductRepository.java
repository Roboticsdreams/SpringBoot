package com.codewithprojectsrefreshtokenauth.repository;

import com.codewithprojectsrefreshtokenauth.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
