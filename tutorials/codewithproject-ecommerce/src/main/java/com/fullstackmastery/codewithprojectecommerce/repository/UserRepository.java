package com.fullstackmastery.codewithprojectecommerce.repository;

import com.fullstackmastery.codewithprojectecommerce.enitity.User;
import com.fullstackmastery.codewithprojectecommerce.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User findByRole(UserRole userRole);
}
