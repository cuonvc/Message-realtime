package com.project.message.messagerealtime.service.impl;

import com.project.message.messagerealtime.constraint.CustomIdGenerator;
import com.project.message.messagerealtime.exception.ResourceNotFoundException;
import com.project.message.messagerealtime.mapper.UserMapper;
import com.project.message.messagerealtime.model.dto.UserDTO;
import com.project.message.messagerealtime.model.entity.User;
import com.project.message.messagerealtime.model.payload.RegisterRequest;
import com.project.message.messagerealtime.repository.UserRepository;
import com.project.message.messagerealtime.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper mapper;

    private final UserMapper userMapper;

    private final EntityManager entityManager;

    @Override
    public UserDTO create(RegisterRequest regRequest) {
        regRequest.setRegisterDate(LocalDateTime.now());
        User userCreated = userRepository.save(userMapper.mapUserFromRegRequest(regRequest));
        return userMapper.mapUserDTOFromUser(userCreated);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        User userTarget = userRepository.findById(userDTO.getId())
                .orElseThrow(ResourceNotFoundException::new);
        mapper.map(userDTO, userTarget);

        return mapper.map(userRepository.save(userTarget), UserDTO.class);
    }

    @Override
    public UserDTO getById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
