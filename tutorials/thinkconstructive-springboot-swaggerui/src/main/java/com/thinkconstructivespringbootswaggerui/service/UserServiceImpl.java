package com.thinkconstructivespringbootswaggerui.service;

import com.thinkconstructivespringbootswaggerui.model.User;
import com.thinkconstructivespringbootswaggerui.repositorty.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByID(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(User user) {
        User userFromDb = userRepository.findById(user.getId()).orElse(null);
        if(userFromDb != null) {
            userFromDb.setName(user.getName());
            userFromDb.setAddress(user.getAddress());
            return userRepository.save(userFromDb);
        }
        return null;
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
