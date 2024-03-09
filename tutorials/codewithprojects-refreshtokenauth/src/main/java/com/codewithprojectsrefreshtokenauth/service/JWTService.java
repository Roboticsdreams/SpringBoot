package com.codewithprojectsrefreshtokenauth.service;

import com.codewithprojectsrefreshtokenauth.dto.AuthResponse;
import com.codewithprojectsrefreshtokenauth.dto.RefreshTokenRequest;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Map;

public interface JWTService {
    public String generateToken(String username);
    public String generateRefreshToken(Map<String, Object> extraClaims, String username);
    public String extractUserName(String token);
    public boolean isTokenValid(String token, UserDetails userDetails);

}
