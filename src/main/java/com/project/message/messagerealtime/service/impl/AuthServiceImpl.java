package com.project.message.messagerealtime.service.impl;

import com.project.message.messagerealtime.exception.ResourceNotFoundException;
import com.project.message.messagerealtime.mapper.UserMapper;
import com.project.message.messagerealtime.model.entity.User;
import com.project.message.messagerealtime.model.payload.RegisterRequest;
import com.project.message.messagerealtime.repository.UserRepository;
import com.project.message.messagerealtime.service.AuthService;
import com.project.message.messagerealtime.utils.enumaration.RegisterBy;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    @Override
    public void register(RegisterRequest regRequest) {
        User user = userRepository.findByPhoneNumberOrEmail(regRequest.getPhoneNumber(),
                regRequest.getEmail()).orElse(null);

        if (user != null) {
            throw new RuntimeException("Email or phone number is existed!");
        }

        user = userMapper.mapUserFromRegRequest(regRequest);
        user.setPassword(passwordEncoder.encode(regRequest.getPassword()));
        user.setCreatedBy(RegisterBy.SIGN_IN_FORM.toString());

        userRepository.save(user);
    }

}
