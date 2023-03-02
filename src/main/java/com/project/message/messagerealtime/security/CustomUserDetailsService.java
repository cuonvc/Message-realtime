package com.project.message.messagerealtime.security;

import com.project.message.messagerealtime.model.entity.User;
import com.project.message.messagerealtime.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByPhoneNumberOrEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email or phone number"));

        if (userEntity.getEmail() == null) {
            username = userEntity.getPhoneNumber();
        } else {
            username = userEntity.getEmail();
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(userEntity.getPassword())
                .authorities(userEntity.getWithRole().toString())
                .build();
    }
}
