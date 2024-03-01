package com.codewithprojectspringbootjwtauth.service.auth;

import com.codewithprojectspringbootjwtauth.dto.SignupRequest;
import com.codewithprojectspringbootjwtauth.dto.UserDTO;
import com.codewithprojectspringbootjwtauth.entity.User;
import com.codewithprojectspringbootjwtauth.enums.UserRole;
import com.codewithprojectspringbootjwtauth.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
        @Autowired
        private UserRepository userRepository;

        @Override
        public UserDTO createUser(SignupRequest signupRequest) {
            User user = new User();
            user.setUsername(signupRequest.getUsername());
            user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
            user.setEmail(signupRequest.getEmail());
            user.setRole(UserRole.USER);
            User createdUser = userRepository.save(user);

            UserDTO userDTO = new UserDTO();
            userDTO.setId(createdUser.getId());
            userDTO.setEmail(createdUser.getEmail());
            userDTO.setUsername(createdUser.getUsername());
            userDTO.setRole(createdUser.getRole());

            return userDTO;
        }

        @PostConstruct
        public void createAdminAccount() {
            User adminAccount = userRepository.findByRole(UserRole.ADMIN);
            if (adminAccount == null) {
                User user = new User();
                user.setUsername("admin");
                user.setEmail("admin@test.com");
                user.setRole(UserRole.ADMIN);
                user.setPassword(new BCryptPasswordEncoder().encode("admin"));
                userRepository.save(user);
            }
        }

        @Override
        public boolean hasUserWithUserName(String username) {
            return userRepository.findByUsername(username).isPresent();
        }
    }

