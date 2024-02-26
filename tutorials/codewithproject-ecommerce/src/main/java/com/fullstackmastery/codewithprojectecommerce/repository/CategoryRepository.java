package com.fullstackmastery.codewithprojectecommerce.repository;

import com.fullstackmastery.codewithprojectecommerce.enitity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
