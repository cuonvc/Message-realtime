package com.project.message.messagerealtime.service;


import com.project.message.messagerealtime.model.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDTO create(UserDTO userDTO);
    UserDTO update(UserDTO userDTO);
    UserDTO getById(String id);
    void delete(String id);
}
