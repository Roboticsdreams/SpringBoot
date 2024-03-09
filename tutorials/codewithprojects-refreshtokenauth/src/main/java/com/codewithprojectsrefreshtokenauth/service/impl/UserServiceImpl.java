package com.codewithprojectsrefreshtokenauth.service.impl;

import com.codewithprojectsrefreshtokenauth.entity.User;
import com.codewithprojectsrefreshtokenauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

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
