package com.codewithprojectsrefreshtokenauth.service.impl;

import com.codewithprojectsrefreshtokenauth.dto.*;
import com.codewithprojectsrefreshtokenauth.entity.User;
import com.codewithprojectsrefreshtokenauth.enums.UserRole;
import com.codewithprojectsrefreshtokenauth.repository.UserRepository;
import com.codewithprojectsrefreshtokenauth.service.AuthService;
import com.codewithprojectsrefreshtokenauth.service.JWTService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Override
    public UserDTO createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(UserRole.USER);
        User createdUser = userRepository.save(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUser.getId());
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
            user.setRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }

    @Override
    public boolean hasUserWithUserName(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public AuthResponse getRefreshToken(RefreshTokenRequest refreshToken) {
        final String username = jwtService.extractUserName(refreshToken.getToken());
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("user not found")
        );
        if (jwtService.isTokenValid(refreshToken.getToken(),user)) {
            final String jwt = jwtService.generateToken(user.getUsername());
            final String newrefreshToken = jwtService.generateRefreshToken(new HashMap<>(), user.getUsername());
            AuthResponse response = new AuthResponse();
            response.setRefreshToken(newrefreshToken);
            response.setToken(jwt);
            return response;
        }
        return null;
    }

    @Override
    public AuthResponse getAccessToken(SigninRequest signinRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUsername(),signinRequest.getPassword()));
        } catch(BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect username or password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(signinRequest.getUsername());
        Optional<User> optionalUser = userRepository.findByUsername(userDetails.getUsername());
        final String jwt = jwtService.generateToken(userDetails.getUsername());
        final String refreshToken = jwtService.generateRefreshToken(new HashMap<>(), userDetails.getUsername());

        if (optionalUser.isPresent()) {
            AuthResponse response = new AuthResponse();
            response.setRefreshToken(refreshToken);
            response.setToken(jwt);
            return response;
        }
        return null;
    }
}
