package com.project.message.messagerealtime.controller;

import com.project.message.messagerealtime.model.dto.UserDTO;
import com.project.message.messagerealtime.model.payload.RegisterRequest;
import com.project.message.messagerealtime.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/form/signup")
    private ResponseEntity<?> register(@RequestBody @Valid RegisterRequest request) {
        userService.create(request);
        return new ResponseEntity<>("Register successfully!", HttpStatus.CREATED);
    }

}
