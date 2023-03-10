package com.project.message.messagerealtime.service;

import com.project.message.messagerealtime.model.dto.UserDTO;
import com.project.message.messagerealtime.model.payload.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    void register(RegisterRequest request);

}
