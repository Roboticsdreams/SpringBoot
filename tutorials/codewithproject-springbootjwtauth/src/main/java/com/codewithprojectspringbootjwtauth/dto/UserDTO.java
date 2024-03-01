package com.codewithprojectspringbootjwtauth.dto;

import com.codewithprojectspringbootjwtauth.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {
    private Long Id;
    private String username;
    private String password;
    private String email;
    private UserRole role;
}
