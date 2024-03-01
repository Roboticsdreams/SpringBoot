package com.codewithprojectspringbootjwtauth.repository;

import com.codewithprojectspringbootjwtauth.entity.User;
import com.codewithprojectspringbootjwtauth.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    User findByRole(UserRole role);
}
