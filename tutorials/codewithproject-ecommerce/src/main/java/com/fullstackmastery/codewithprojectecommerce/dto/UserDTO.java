package com.fullstackmastery.codewithprojectecommerce.dto;

import com.fullstackmastery.codewithprojectecommerce.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String name;
    private UserRole userRole;
}
