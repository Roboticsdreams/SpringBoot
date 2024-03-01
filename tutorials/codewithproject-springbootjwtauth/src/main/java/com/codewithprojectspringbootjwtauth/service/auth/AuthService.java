package com.codewithprojectspringbootjwtauth.service.auth;

import com.codewithprojectspringbootjwtauth.dto.SignupRequest;
import com.codewithprojectspringbootjwtauth.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupRequest signupRequest);
    boolean hasUserWithUserName(String username);
}
