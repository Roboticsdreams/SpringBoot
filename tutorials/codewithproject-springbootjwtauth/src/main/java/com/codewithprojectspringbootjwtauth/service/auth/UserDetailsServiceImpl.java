package com.codewithprojectspringbootjwtauth.service.auth;

import com.codewithprojectspringbootjwtauth.entity.User;
import com.codewithprojectspringbootjwtauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalUser.isPresent()){
            return new org.springframework.security.core.userdetails.User(
                    optionalUser.get().getUsername(),
                    optionalUser.get().getPassword(),
                    optionalUser.get().isEnabled(),
                    optionalUser.get().isAccountNonExpired(),
                    optionalUser.get().isCredentialsNonExpired(),
                    optionalUser.get().isAccountNonLocked(),
                    optionalUser.get().getAuthorities());
        }
        else {
            throw new UsernameNotFoundException("Username not exists");
        }
    }
}
