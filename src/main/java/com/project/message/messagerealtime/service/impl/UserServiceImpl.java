package com.project.message.messagerealtime.service.impl;

import com.project.message.messagerealtime.exception.ResourceNotFoundException;
import com.project.message.messagerealtime.model.dto.UserDTO;
import com.project.message.messagerealtime.model.entity.User;
import com.project.message.messagerealtime.repository.UserRepository;
import com.project.message.messagerealtime.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper mapper;

    @Override
    public UserDTO create(UserDTO userDTO) {

        User userCreated = userRepository.save(mapper.map(userDTO, User.class));
        return mapper.map(userCreated, UserDTO.class);
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
