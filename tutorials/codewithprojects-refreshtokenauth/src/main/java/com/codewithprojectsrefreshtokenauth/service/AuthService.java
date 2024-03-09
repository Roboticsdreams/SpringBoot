package com.codewithprojectsrefreshtokenauth.service;

import com.codewithprojectsrefreshtokenauth.dto.*;

public interface AuthService {
    UserDTO createUser(SignupRequest signupRequest);
    boolean hasUserWithUserName(String username);
    AuthResponse getAccessToken(SigninRequest signinRequest);
    AuthResponse getRefreshToken(RefreshTokenRequest refreshToken);
}

