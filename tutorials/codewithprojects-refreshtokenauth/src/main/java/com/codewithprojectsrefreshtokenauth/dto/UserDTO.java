package com.codewithprojectsrefreshtokenauth.dto;

import com.codewithprojectsrefreshtokenauth.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {
    private Long Id;
    private String username;
    private UserRole role;
}
