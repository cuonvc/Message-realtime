package com.project.message.messagerealtime.controller;

import com.project.message.messagerealtime.model.dto.UserDTO;
import com.project.message.messagerealtime.model.payload.RegisterRequest;
import com.project.message.messagerealtime.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    private ResponseEntity<UserDTO> register(@RequestBody @Valid RegisterRequest request) {
        return new ResponseEntity<>(userService.create(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<UserDTO> update(@PathVariable(name = "id") String userId,
                                           @RequestBody UserDTO userDTO) {
        userDTO.setId(userId);
        return new ResponseEntity<>(userService.update(userDTO), HttpStatus.OK);
    }
}
