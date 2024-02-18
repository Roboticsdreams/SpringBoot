package com.thinkconstructivespringbootswaggerui.service;

import com.thinkconstructivespringbootswaggerui.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();
    Optional<User> getUserByID(Long id);
    User updateUser(User user);
    void deleteUser(User user);
}
