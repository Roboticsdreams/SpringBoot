package com.fullstackmastery.codewithprojectecommerce.services.auth;

import com.fullstackmastery.codewithprojectecommerce.dto.SignupRequest;
import com.fullstackmastery.codewithprojectecommerce.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupRequest signupRequest);
    boolean hasUserWithEmail(String email);
}
